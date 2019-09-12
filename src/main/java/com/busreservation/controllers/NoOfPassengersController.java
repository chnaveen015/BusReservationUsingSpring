package com.busreservation.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.busreservation.bean.Details;
import com.busreservation.bean.Reservation;

@Controller
public class NoOfPassengersController {
	@Autowired
	Environment environment;
	@RequestMapping(value="NumberOfPassengers",method=RequestMethod.POST)
	public ModelAndView getPassengersDetails(Details details)
	{
		System.out.println(details);
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
	@GetMapping(value="NoOfPassengerDetials")
	public ModelAndView getBusIds(HttpSession session)
	{
		String port = environment.getProperty("local.server.port");
		String url= "http://localhost:"+port+"/AdminFunctionalities/get-busid's";
		RestTemplate rest = new RestTemplate();
		ModelAndView modelAndView = new ModelAndView();
		ResponseEntity<ArrayList<Integer>> responseEntity = rest.exchange(url, HttpMethod.GET,
				null, new ParameterizedTypeReference<ArrayList<Integer>>() {
		});		
		modelAndView.setViewName("NoOfPassengers");	
		session.setAttribute("busesId",responseEntity.getBody());
		
		return modelAndView;
	
		
	}
	
}
