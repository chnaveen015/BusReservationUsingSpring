package com.busreservation.controllers;

import java.util.ArrayList; 

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.busreservation.bean.BusDetails;
import com.busreservation.bean.Journey;
import com.busreservation.bean.Reservation;

@Controller
public class ReservationController {
	@Autowired
	Environment environment;
	@Autowired
	Journey journey;
	@RequestMapping(value="BeginReservation",method=RequestMethod.POST)
	public ModelAndView getReservationDetails(HttpSession session,HttpServletRequest request)
	{
		int bus_id=(Integer.parseInt(request.getParameter("bus_id")));
		@SuppressWarnings("unchecked")
		ArrayList<BusDetails>details=(ArrayList<BusDetails>) session.getAttribute("viewBuses");
		ModelAndView modelAndView=new ModelAndView();
		if(details!=null)
			for(BusDetails busDetails:details)
			{
				if(bus_id==busDetails.getBus_id())
				{

					modelAndView.setViewName("Reservation");
					modelAndView.addObject("busDetails", busDetails);
					session.removeAttribute("viewBuses");
					return modelAndView;
				}
			}
		return modelAndView;
	}
	@RequestMapping(value="Reservation",method=RequestMethod.POST)
	public ModelAndView reserveTicket(HttpSession session,HttpServletRequest request,Reservation reservationDetails)
	{
		String port = environment.getProperty("local.server.port");
		String url= "http://localhost:"+port+"/BusResources";
		RestTemplate restTemplate=new RestTemplate();
		ResponseEntity<Integer> pnr=restTemplate.exchange(url+"/GetPnr",HttpMethod.GET,null,Integer.class);
		Integer journey_id=(Integer.parseInt(request.getParameter("journey_id")));
		Journey journey=restTemplate.postForObject(url+"/GetJourneyDetails",journey_id,Journey.class);
		reservationDetails.setJourney(journey);
		reservationDetails.setPnr(pnr.getBody());
		String status=restTemplate.postForObject(url+"/ReserveTicket",reservationDetails,String.class);
		ModelAndView modelAndView=new ModelAndView("Ticket");
		if(status.equals("yes"))
		modelAndView.addObject("ticket",reservationDetails);
		return modelAndView;

	}

}

