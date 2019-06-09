package com.ani.eshopbackend.daoimpl;

import org.springframework.web.bind.annotation.RequestMapping;

public class HomeController {
public HomeController() {
		
	}
	@RequestMapping("/home")
	public String goToHome()
	{
		return "UserHome";
	}

}
