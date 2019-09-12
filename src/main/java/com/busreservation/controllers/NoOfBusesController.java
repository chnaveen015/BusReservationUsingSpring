package com.busreservation.controllers;

import java.io.IOException; 
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.busreservation.bean.NoOfBusesDetails;

@Controller
public class NoOfBusesController {
	@Autowired
	Environment environment;

	/*
	 * This method returns 
	 */
	@RequestMapping("noOfBusesController")
	public ModelAndView getBusesSourceDestination(HttpSession session) {
		String port = environment.getProperty("local.server.port");
		String url = "http://localhost:" + port + "/BusResources";
		ModelAndView modelAndView = new ModelAndView("NoOfBuses");
		RestTemplate rest = new RestTemplate();

		ResponseEntity<List<String>> responseEntity = rest.exchange(url+"/Getsource",
				HttpMethod.GET, null, new ParameterizedTypeReference<List<String>>() {
		});
		session.setAttribute("sources", responseEntity.getBody());
		ResponseEntity<List<String>> responseEntity1 = rest.exchange(
				url+"/Getdestination", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<String>>() {
				});
		session.setAttribute("destinations", responseEntity1.getBody());

		return modelAndView;
	}

	@RequestMapping(value = "GetNoOfBuses", method = RequestMethod.POST)
	public ModelAndView getNoOfBuses(NoOfBusesDetails details, HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		String port = environment.getProperty("local.server.port");
		String url = "http://localhost:" + port + "/AdminFunctionalities/total-No-Of-buses";
		RestTemplate rest = new RestTemplate();
		ModelAndView modelAndView = new ModelAndView("BusesCount");
		Integer count = rest.postForObject(url, details,
				Integer.class);

		modelAndView.addObject("count", count);

		return modelAndView;
	}

}
