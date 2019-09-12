package com.busreservation.controllers;

import javax.servlet.http.HttpServletRequest;  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.busreservation.bean.Reservation;

@Controller
public class CancelTicketController {
	@Autowired
	Environment environment;

	/*
	 * It is called from CancelTicket.jsp
	 * It will take pnr number as input and forward it to the ViewTicket rest call and returns the ticket details
	 * else prompt the user to enter valid pnr number!
	 */
	@RequestMapping(value="CancelTicket",method=RequestMethod.POST)
	public ModelAndView cancelTicket(HttpServletRequest request)
	{
		String port = environment.getProperty("local.server.port");
		String url= "http://localhost:"+port+"/BusResources/ViewTicket";
		Integer pnr=Integer.parseInt(request.getParameter("pnr"));
		RestTemplate rest=new RestTemplate();
		Reservation ticket=rest.postForObject(url, pnr, Reservation.class);
		ModelAndView modelAndView=new ModelAndView("ConfirmCancellation");
		if(ticket!=null)
			modelAndView.addObject("ticket",ticket);	
		return modelAndView;
	}
	/*
	 * It is called from ProceedCancellation.jsp 
	 * it will take pnr number as input and retrieve the ticket details and forwards that details to CancelTicket Rest call
	 * and gets the status of the cancellation.
	 */
	@RequestMapping(value="ProceedCancellation",method=RequestMethod.POST)
	public ModelAndView proceedCancellation(HttpServletRequest request)
	{
		String port = environment.getProperty("local.server.port");
		String url= "http://localhost:"+port+"/BusResources";
		RestTemplate rest=new RestTemplate();
		Integer pnr=Integer.parseInt(request.getParameter("pnr"));
		Reservation reservationDetails=rest.postForObject(url+"/ViewTicket", pnr, Reservation.class);
		String status=rest.postForObject(url+"/CancelTicket", reservationDetails, String.class);
		ModelAndView modelAndView=new ModelAndView("CancelTicket");
		modelAndView.addObject("status",status);

		return modelAndView;
	}
}
