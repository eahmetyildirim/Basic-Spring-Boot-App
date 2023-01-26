package net.finalproject.controller;

import java.util.*;

import net.finalproject.models.*;
import net.finalproject.service.CategoryService;
import net.finalproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
	@Autowired
	UserService userService;
	@Autowired
	private CategoryService categoryService;

	@RequestMapping("/")
	public String home(Model model, Authentication authentication){
		if(Objects.nonNull(authentication) && authentication.isAuthenticated()){
			model.addAttribute("isAuthenticated",authentication.isAuthenticated());
			model.addAttribute("userName",authentication.getName());
		}
		List<Category> categoryList=categoryService.getAllCategory();

		model.addAttribute("categoryList",categoryList);
		return "index";
	}
	@RequestMapping(value = "/giris-yap",method = RequestMethod.GET)
	public String loginPage(Model model) {

		return "redirect:/oauth2/authorization/google";
	}
}
