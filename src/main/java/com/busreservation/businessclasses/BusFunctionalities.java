package com.busreservation.businessclasses;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.busreservation.bean.BasicDetailsBean;
import com.busreservation.bean.Bus;
import com.busreservation.bean.BusDetails;
import com.busreservation.bean.Journey;
import com.busreservation.bean.NoOfBusesDetails;
import com.busreservation.bean.Reservation;
import com.busreservation.bean.TicketCost;
import com.busreservation.serviceclasses.JourneyDao;
import com.busreservation.serviceclasses.SeatAvailableDao;
import com.busreservation.serviceclasses.TicketCostDao;

@Component
public class BusFunctionalities {
	@Autowired
	TicketCostDao ticketCostDao;
	@Autowired
	BusDetails busDetails;
	@Autowired
	JourneyDao journeyDao;
	@Autowired
	SeatAvailableDao seatAvailableDao;

	public ArrayList<BusDetails> getAvailableBus(BasicDetailsBean details) {
		// TODO Auto-generated method stub
		ArrayList<TicketCost> sourceList=ticketCostDao.getSourceList(details);
		ArrayList<TicketCost> destinationList=ticketCostDao.getDestinationList(details);

		Iterator sources = sourceList.iterator();
		Iterator destinations = destinationList.iterator();
		TicketCost source;
		
		Bus sourceBus, destinationBus,bus;
		ArrayList<BusDetails> busDetailsList = new ArrayList<BusDetails>();
		while (sources.hasNext()) {

			source = (TicketCost) sources.next();
			for(TicketCost destination:destinationList)
			{
			sourceBus = source.getBus();
			destinationBus = destination.getBus();
			if (sourceBus.getBus_id() == destinationBus.getBus_id()
					&& source.getRouteno() <= destination.getRouteno()) {
				BusDetails busDetails = new BusDetails();

				busDetails.setBus_id(sourceBus.getBus_id());
				busDetails.setRouteno1(source.getRouteno());
				busDetails.setRouteno2(destination.getRouteno());
				busDetails.setJourney_date(Date.valueOf(details.getDateOfJourney()));
				
				ArrayList<Journey>JourneyList=journeyDao.getJourney(busDetails);
				for (Journey journey : JourneyList) {
					bus = journey.getBus();
					if (bus.getBus_id() == busDetails.getBus_id()) {
						busDetails.setJourney_id(journey.getJourney_id());
						busDetails.setBus_type(bus.getBus_type());
						break;
					}
				}
				if (busDetails.getJourney_id() != 0) {
					Integer availableSeats = seatAvailableDao.getAvailableSeats(busDetails);
					if (availableSeats != null && availableSeats > 0)
					{
						busDetails.setAvailable_seats(availableSeats);
					if (busDetails.getAvailable_seats() >=	 details.getNoOfSeats()) {
						busDetails.setFare(ticketCostDao.getRequiredFare(busDetails));
						busDetailsList.add(busDetails);
					}
				}
				}
			}
		}
		}
		return busDetailsList;	
	}
	
	public Integer getNoOfBuses(NoOfBusesDetails details) {
		// TODO Auto-generated method stub
		ArrayList<TicketCost> sourceList=ticketCostDao.getSourcesList(details.getSource());
		ArrayList<TicketCost> destinationList=ticketCostDao.getDestinationList(details.getDestination());
		Iterator sources = sourceList.iterator();
		Iterator destinations = destinationList.iterator();
		TicketCost source, destination;
		Bus sourceBus, destinationBus;
		int count = 0;
		ArrayList<BusDetails> busDetailsList = new ArrayList<BusDetails>();
		while (sources.hasNext() && destinations.hasNext()) {
			source = (TicketCost) sources.next();
			destination = (TicketCost) destinations.next();
			sourceBus = source.getBus();
			destinationBus = destination.getBus();
			if (sourceBus.getBus_id() == destinationBus.getBus_id()
					&& sourceBus.getBus_id() == destinationBus.getBus_id()) {
				BusDetails busDetails = new BusDetails();
				BusDetails b = new BusDetails();
				busDetails.setBus_id(sourceBus.getBus_id());
				
				count+=journeyDao.getBusCount(busDetails,details);
			}
		}	
		return count;
	}
}
