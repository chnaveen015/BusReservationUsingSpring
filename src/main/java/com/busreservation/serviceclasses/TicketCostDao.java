package com.busreservation.serviceclasses;

import java.util.ArrayList; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.busreservation.bean.BasicDetailsBean;
import com.busreservation.bean.BusDetails;
import com.busreservation.bean.TicketCost;
import com.busreservation.repositories.TicketCostRepository;

@Service
public class TicketCostDao {
	@Autowired
	TicketCostRepository ticketCostRepo;
	//Returns available sources by making method call to TicketCostRepository
	//return type is  List of Strings.
	public ArrayList<String> getSources() {
		return ticketCostRepo.getSources();
	}


	//Returns available destinations by making method call to TicketCostRepository
	//return type is  List of Strings.
	public ArrayList<String> getDestinations() {
	
		return ticketCostRepo.getDestinations();
	}


	public ArrayList<TicketCost> getSourceList(BasicDetailsBean details)
	{

		return ticketCostRepo.getSourcesList(details.getSource());

	}


	public ArrayList<TicketCost> getDestinationList(BasicDetailsBean details) {

		return ticketCostRepo.getDestinationList(details.getDestination());
	
	}

	public Long getRequiredFare(BusDetails details)
	{
		return ticketCostRepo.getFare(details.getRouteno1(),details.getRouteno2());
	}


	public ArrayList<TicketCost> getSourcesList(String source) {

		return ticketCostRepo.getSourcesList(source);
	}
	public ArrayList<TicketCost> getDestinationList(String destination) {

		return ticketCostRepo.getDestinationList(destination);
	}

}
