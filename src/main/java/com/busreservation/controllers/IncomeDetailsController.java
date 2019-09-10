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

import com.busreservation.bean.BasicDetailsBean;
import com.busreservation.bean.BusDetails;
import com.busreservation.bean.Journey;

@Controller
public class IncomeDetailsController {
	@Autowired
	Environment environment;
		/*
		 * It is Called From Income.jsp and it takes dateOfJourney as input and forward that details to view-income restcall
		 * return list of buses and their income.
		 * and redirect those details to IncomeDetails.jsp
		 */
		@RequestMapping(value="/IncomeController",method=RequestMethod.POST)
		public ModelAndView getIncomeDetials(HttpServletRequest request)
		{
			String port = environment.getProperty("local.server.port");
			String url= "http://localhost:"+port+"/AdminFunctionalities/view-income";
			String DateOfJourney=request.getParameter("date");
			HttpHeaders requestHeaders = new HttpHeaders();
			HttpEntity<String> requestEntity = new HttpEntity<>(DateOfJourney, requestHeaders);
			RestTemplate rest = new RestTemplate();
			ModelAndView modelAndView = new ModelAndView();
			ResponseEntity<ArrayList<Journey>> responseEntity = rest.exchange(url, HttpMethod.POST,
					requestEntity, new ParameterizedTypeReference<ArrayList<Journey>>() {
					});		
			modelAndView.setViewName("IncomeDetails");	
			modelAndView.addObject("incomeDetails",responseEntity.getBody());
			return modelAndView;
		}
}
