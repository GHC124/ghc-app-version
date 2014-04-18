package com.ghc.appversion.web.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ghc.appversion.web.form.Message;

@RequestMapping("/login")
@Controller
public class LoginController extends AbstractController {
	
	public String loginForm(Model model, Locale locale){
		return "login";
	}
	
	
	
	@RequestMapping("/loginfail")
	public String loginFail(Model model, Locale locale){
		model.addAttribute(
				"message",
				new Message("error", messageSource.getMessage(
						"message_login_fail", new Object[]{}, locale)));
		return "login";
	}
}
