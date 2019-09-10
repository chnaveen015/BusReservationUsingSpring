package com.busreservation.controllers;

import java.util.ArrayList; 
import java.util.List;

import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.busreservation.bean.BasicDetailsBean;
import com.busreservation.bean.BusDetails;

@Controller
public class AvailableBusesController {
	@Autowired
	Environment environment;
	/*
	 * It is called from User.jsp page It send Available Buses List to ViewBuses.jsp
	 * Based on the User Journey Details Parameters are BasicDetailsBean object
	 * contains user entered details
	 * 
	 * 
	 */
	@RequestMapping(value = "/GetAvailableBuses", method = RequestMethod.POST)
	public ModelAndView getBuses(BasicDetailsBean details, HttpSession session) {
		
		String port = environment.getProperty("local.server.port");
		String url="http://localhost:"+port+"/BusResources/AvailableBuses";
		ModelAndView modelAndView = new ModelAndView();
		HttpHeaders requestHeaders = new HttpHeaders();
		if (!details.getSource().equals(details.getDestination())) {
			HttpEntity<BasicDetailsBean> requestEntity = new HttpEntity<>(details, requestHeaders);
			RestTemplate rest = new RestTemplate();
			/*
			 * It Will make a Rest call to Available buses and get list of available buses
			 * located in the BusResources and return to ViewBuses.jsp page
			 */
			ResponseEntity<ArrayList<BusDetails>> responseEntity = rest.exchange(
					url, HttpMethod.POST, requestEntity,
					new ParameterizedTypeReference<ArrayList<BusDetails>>() {
					});
			session.setAttribute("viewBuses", responseEntity.getBody());
			session.setAttribute("details", details);
			if (responseEntity.getBody().size() != 0)
				modelAndView.setViewName("ViewBuses");
			else {
				modelAndView.addObject("msg", "No Buses Are Available!");
				modelAndView.setViewName("User");
			}
		} else {
			modelAndView.setViewName("User");
			modelAndView.addObject("msg", "Source And Destination Should Not Be Same!");

		}
		return modelAndView;

	}

}
