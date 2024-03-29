package com.busreservation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.busreservation.bean.Login;

@Controller
public class LoginController {
	@Autowired
	Environment environment;

	/*
	 * It is called from Login.jsp It takes user name and password as input and
	 * forward it to GetAuthorizationStatus RestCall It returns whether credentials
	 * are valid or invalid!
	 */
	@RequestMapping("/LoginValidator")
	public ModelAndView getDetils(Login login) {
		String port = environment.getProperty("local.server.port");
		String url = "http://localhost:" + port + "/LoginResource/GetAuthorizationStatus";

		ModelAndView modelAndView = new ModelAndView();

		RestTemplate rest = new RestTemplate();
		String validate = rest.postForObject(url, login, String.class);

		modelAndView.addObject("validate", validate);
		if (validate.equals("valid"))
			modelAndView.setViewName("Admin");
		else {
			modelAndView.addObject("message", "enter valid credentials!");
			modelAndView.setViewName("Login");
		}
		return modelAndView;
	}
}
