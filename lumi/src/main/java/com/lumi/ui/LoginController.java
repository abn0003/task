package com.lumi.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.lumi.domain.UserInfoLog;
import com.lumi.sv.LoginService;

@Controller
public class LoginController {
	
	@Autowired 
	private LoginService loginService;

	@GetMapping("/")
	public String index(Model model) {
		UserInfoLog userInfoLog = loginService.logUserInfo();
		model.addAttribute("userInfoLog", userInfoLog);
		return "index";
	}
}