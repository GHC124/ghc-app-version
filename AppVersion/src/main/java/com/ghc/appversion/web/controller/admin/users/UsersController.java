package com.ghc.appversion.web.controller.admin.users;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ghc.appversion.web.controller.admin.AbstractAdminController;

@RequestMapping("/admin/users")
@Controller
public class UsersController extends AbstractAdminController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model){
		
		return "admin/users/list";		
	}
}
