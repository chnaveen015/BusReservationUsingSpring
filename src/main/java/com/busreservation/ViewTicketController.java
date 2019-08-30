package com.busreservation;

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
public class ViewTicketController {
	@Autowired
	Environment environment;
	@RequestMapping(value="ViewTicket",method=RequestMethod.POST)
	public ModelAndView getTicket(HttpServletRequest request)
	{
		String port = environment.getProperty("local.server.port");
		String url= "http://localhost:"+port+"/BusResources/ViewTicket";
		Integer pnr=Integer.parseInt(request.getParameter("pnr"));
		RestTemplate rest=new RestTemplate();
		Reservation ticket=rest.postForObject(url, pnr, Reservation.class);
		ModelAndView modelAndView=new ModelAndView("Ticket");
		modelAndView.addObject("ticket",ticket);	
		return modelAndView;
	}
}
