package com.busreservation.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

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

import com.busreservation.bean.Details;
import com.busreservation.bean.Journey;
import com.busreservation.bean.Reservation;

@Controller
public class NoOfPassengersController {
	@Autowired
	Environment environment;
		@RequestMapping(value="NoPassengers",method=RequestMethod.POST)
		public ModelAndView getPassengersDetails(Details details)
		{
			String port = environment.getProperty("local.server.port");
			String url= "http://localhost:"+port+"/AdminFunctionalities/view-passengers";
			HttpHeaders requestHeaders = new HttpHeaders();
			HttpEntity<Details> requestEntity = new HttpEntity<>(details, requestHeaders);
			RestTemplate rest = new RestTemplate();
			ModelAndView modelAndView = new ModelAndView();
			ResponseEntity<ArrayList<Reservation>> responseEntity = rest.exchange(url, HttpMethod.POST,
					requestEntity, new ParameterizedTypeReference<ArrayList<Reservation>>() {
					});		
			modelAndView.setViewName("Passengers");	
			
			modelAndView.addObject("passengers",responseEntity.getBody());
			return modelAndView;
		}
}
