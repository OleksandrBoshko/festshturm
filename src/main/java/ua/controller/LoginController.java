package ua.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.User;
import com.service.UserService;

@Controller
public class LoginController {
	@Autowired 
	private UserService userService;
		
	@RequestMapping("/login")
	public String findOneUser(Model model){
		model.addAttribute("users", userService.getAll());
		return "login";
	}	
}
