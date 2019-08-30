package com.busreservation;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.busreservation.bean.BasicDetailsBean;

@Controller
public class UserController {
	@Autowired
	Environment environment;
	
	/* called From Welcome.jsp 
	 * it will redirect to another jsp pages based on the action performed.
	 * It will forward if action is Reserve Ticket Available Source and Destination List to jsp page to display there
	 */
	@RequestMapping("/UserController")
	public ModelAndView getDetils(HttpServletRequest request,HttpSession session) {
		String port = environment.getProperty("local.server.port");
		String url= "http://localhost:"+port+"/BusResources";
		String operation = (String) request.getParameter("operation");
		ModelAndView modelAndView = new ModelAndView();
		if (operation.equals("ReserveTicket")) {
			RestTemplate rest = new RestTemplate();
			/*
			 * It make Rest Call To Getsources located in BusResources to get available Sources As a list.
			 */
			ResponseEntity<List<String>> responseEntity = rest.exchange(url+"/Getsource", HttpMethod.GET,
					null, new ParameterizedTypeReference<List<String>>() {
					});
			session.setAttribute("sources", responseEntity.getBody());
			/*
			 * It make Rest Call To GetDestination located in BusResources to get available Destination As a list.
			 */
			ResponseEntity<List<String>> responseEntity1 = rest.exchange(url+"/Getdestination",
					HttpMethod.GET, null, new ParameterizedTypeReference<List<String>>() {
					});
			session.setAttribute("destinations", responseEntity1.getBody());
			modelAndView.setViewName("User");
			return modelAndView;
		}
		else if (operation.equals("CancelTicket")) {
				modelAndView.setViewName("CancelTicket");
				return modelAndView;
		} else if (operation.equals("viewticket")) {
			modelAndView.setViewName("ViewTicket");
			return modelAndView;
		}
		return null;

	}

}
