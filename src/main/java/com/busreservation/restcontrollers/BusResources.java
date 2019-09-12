package com.busreservation.restcontrollers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.busreservation.bean.BasicDetailsBean;
import com.busreservation.bean.BusDetails;
import com.busreservation.bean.Journey;
import com.busreservation.bean.Reservation;
import com.busreservation.businessclasses.BusFunctionalities;
import com.busreservation.businessclasses.PnrGeneration;
import com.busreservation.repositories.ReservationRepository;
import com.busreservation.repositories.TicketCostRepository;
import com.busreservation.serviceclasses.JourneyDao;
import com.busreservation.serviceclasses.ReservationDao;
import com.busreservation.serviceclasses.SeatAvailableDao;
import com.busreservation.serviceclasses.TicketCostDao;

@RestController
@RequestMapping("/BusResources")
public class BusResources {
	@Autowired
	TicketCostDao ticketCostDao;
	@Autowired
	BusFunctionalities busFunctions;
	@Autowired
	ReservationDao reservation;
	@Autowired
	PnrGeneration pnrGenerator;
	@Autowired
	SeatAvailableDao seatAvaibaleDao;
	@Autowired
	TicketCostRepository ticketCostRepo;
	@Autowired
	ReservationRepository reservationRepo;
	@Autowired
	JourneyDao journeyDao;


	/*
	 * It will make a call to TicketCostDao and get List of available  sources.
	 */
	@GetMapping(value = "/Getsource")
	public ArrayList<String> getSources() {
		return ticketCostDao.getSources();

	}

	/*
	 * It will make a call to TicketCostDao and get List Available Destinations.
	 */
	@GetMapping(value = "/Getdestination")
	public ArrayList<String> getDestination() {
		return ticketCostDao.getDestinations();
	}

	/*
	 * it is called from Available Buses Controller
	 * it make a call to getAvailableBuses Method located in  business class namely BusFunctionalities
	 * it will get list of available buses and returns to controller.
	 */
	@RequestMapping(value = "/AvailableBuses", method = RequestMethod.POST)
	public ArrayList<BusDetails> getBuses(@RequestBody BasicDetailsBean details) {

		ArrayList<BusDetails> busDetailsList = busFunctions.getAvailableBus(details);
		return busDetailsList;
	}

	@RequestMapping(value = "/ViewTicket", method = RequestMethod.POST)
	public Reservation viewTicket(@RequestBody Integer pnr) {

		Optional<Reservation> ticket = reservation.viewTicket(pnr);
		if(ticket.isPresent())
			return ticket.get();
		else
			return null;
	}


	/*
	 * It will make a call to getPnr method located in PnrGeneration Class
	 */
	@RequestMapping(value = "/GetPnr", method = RequestMethod.GET)
	public Integer generatePnr() {
		return pnrGenerator.getPnr();
	}


	/*
	 * This Method returns the status of the reservation of the ticket.
	 * This method make certain calls to different methods to decrease the number of seats after reservation
	 * finally insert the reserved ticket details into the database.   
	 */
	@RequestMapping(value="/ReserveTicket",method=RequestMethod.POST)
	public String reserveTicket(@RequestBody Reservation reserveTicket)
	{
		Integer flag=seatAvaibaleDao.decreaseNoOfSeats(reserveTicket);
		if(flag!=null && flag>0)
		{
			Integer updateCost=journeyDao.increaseCost(reserveTicket.getFare(),reserveTicket.getJourney().getJourney_id());
			if(updateCost!=null && updateCost>0)
			{
				if(reservation.insertTicketDetails(reserveTicket)!=null);
				return "yes";
			}

		}
		return "no";

	}
	/*
	 * This Method Returns the journey details based on the journey id.
	 */
	@RequestMapping(value="GetJourneyDetails",method=RequestMethod.POST)
	public Journey getJourneyDetails(@RequestBody Integer journey_id)
	{

		return journeyDao.getJourneyDetails(journey_id);

	}

	/*
	 * This Method returns the status of the cancellation of the ticket.
	 * This method make certain calls to different methods to increase the number of seats after cancellation
	 * finally delete the reserved ticket details from the database.   
	 * 
	 */
	@RequestMapping(value="/CancelTicket",method=RequestMethod.POST)
	public String cancelTicket(@RequestBody Reservation reservedTicket)
	{
		Integer flag=seatAvaibaleDao.increaseNoOfSeats(reservedTicket);
		System.out.println(reservedTicket);
		System.out.println(flag);
		if(flag!=null && flag>=0)
		{
			Integer updateCost=journeyDao.duductCost(reservedTicket.getFare(),reservedTicket.getJourney().getJourney_id());
			if(updateCost!=null && updateCost>=0)
			{
				if(reservation.removeTicketDetails(reservedTicket)!=null);
				return "yes";
			}

		}
		return "no";

	}
}
