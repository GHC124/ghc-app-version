package com.ghc.appversion.web.controller.admin;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ghc.appversion.domain.admin.User;
import com.ghc.appversion.service.jpa.admin.UserService;
import com.ghc.appversion.web.form.Message;
import com.ghc.appversion.web.form.ValidationResponse;
import com.ghc.appversion.web.form.admin.UserGrid;
import com.ghc.appversion.web.util.UrlUtil;

@RequestMapping("/admin/users")
@Controller
public class UsersController extends AbstractAdminController {

	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "admin/users/list";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String show(@PathVariable(value = "id") Long id, Model model) {
		User user = userService.findById(id);
		model.addAttribute("user", user);

		return "admin/users/show";
	}

	@RequestMapping(params = "json")
	@ResponseBody
	public ValidationResponse processForm(Model model, @Valid User user,
			BindingResult result) {
		ValidationResponse res = new ValidationResponse();
		if (!result.hasErrors()) {
			res.setStatus("success");
			userService.save(user);
		}else{
			res.setStatus("error");
			res.setResult(result.getAllErrors());
		}

		return res;
	}

	@RequestMapping(params = "form", method = RequestMethod.GET)
	public String createForm(Model model) {
		User user = new User();
		model.addAttribute("user", user);

		return "admin/users/create";
	}

	@RequestMapping(params = "form", method = RequestMethod.POST)
	public String create(@Valid User user, BindingResult bindingResult,
			Model model, HttpServletRequest httpServletRequest,
			RedirectAttributes redirectAttributes, Locale locale) {
		if (bindingResult.hasErrors()) {
			model.addAttribute(
					"message",
					new Message("error", messageSource.getMessage(
							"admin_user_save_fail", new Object[] {}, locale)));
			model.addAttribute("user", user);
			return "admin/users/create";
		}
		model.asMap().clear();
		redirectAttributes.addFlashAttribute(
				"message",
				new Message("success", messageSource.getMessage(
						"admin_user_save_success", new Object[] {}, locale)));
		userService.save(user);

		return "admin/users/create";
	}

	@RequestMapping(value = "/{id}", params = "form", method = RequestMethod.GET)
	public String updateForm(@PathVariable(value = "id") Long id, Model model) {
		User user = userService.findById(id);
		model.addAttribute("user", user);

		return "admin/users/update";
	}

	@RequestMapping(value = "/{id}", params = "form", method = RequestMethod.POST)
	public String update(@Valid User user, BindingResult bindingResult,
			Model model, HttpServletRequest httpServletRequest,
			RedirectAttributes redirectAttributes, Locale locale) {
		if (bindingResult.hasErrors()) {
			model.addAttribute(
					"message",
					new Message("error", messageSource.getMessage(
							"admin_user_save_fail", new Object[] {}, locale)));
			model.addAttribute("user", user);
			return "admin/users/create";
		}
		model.asMap().clear();
		redirectAttributes.addFlashAttribute(
				"message",
				new Message("success", messageSource.getMessage(
						"admin_user_save_success", new Object[] {}, locale)));
		userService.save(user);

		return "redirect:admin/users/"
				+ UrlUtil.encodeUrlPathSegment(user.getId().toString(),
						httpServletRequest);
	}

	@RequestMapping(value = "/listgrid", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public UserGrid listGrid(
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "rows", required = false) Integer rows,
			@RequestParam(value = "sidx", required = false) String sortBy,
			@RequestParam(value = "sord", required = false) String order) {
		Sort sort = null;
		String orderBy = sortBy;
		if (orderBy != null && order != null) {
			if (order.equals("desc")) {
				sort = new Sort(Sort.Direction.DESC, orderBy);
			} else {
				sort = new Sort(Sort.Direction.ASC, orderBy);
			}
		}
		PageRequest pageRequest = null;
		if (sort != null) {
			pageRequest = new PageRequest(page - 1, rows, sort);
		} else {
			pageRequest = new PageRequest(page - 1, rows);
		}
		Page<User> userPage = userService.findAllByPage(pageRequest);
		UserGrid userGrid = new UserGrid();
		userGrid.setCurrentPage(userPage.getNumber() + 1);
		userGrid.setTotalPages(userPage.getTotalPages());
		userGrid.setTotalRecords(userPage.getTotalElements());
		userGrid.setUserData(userPage.getContent());

		return userGrid;
	}
}
