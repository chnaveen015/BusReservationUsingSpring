package com.busreservation.restcontrollers;

import java.util.ArrayList; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.busreservation.bean.Details;
import com.busreservation.bean.Journey;
import com.busreservation.bean.NoOfBusesDetails;
import com.busreservation.bean.Reservation;
import com.busreservation.businessclasses.BusFunctionalities;
import com.busreservation.serviceclasses.AdminDao;
import com.busreservation.serviceclasses.BusDao;


@RestController
@RequestMapping("AdminFunctionalities")
public class AdminResources {
	@Autowired
	AdminDao adminDao;
	@Autowired
	BusFunctionalities busFunctions;
	@Autowired
	BusDao busDao;

	/*
	 * This method returns the income details of buses.
	 * this method take date of journey as a input.
	 */
	@RequestMapping(value="view-income",method=RequestMethod.POST)
	public ArrayList<Journey> getIncomeDetails(@RequestBody String dateOfJourney)
	{
		ArrayList<Journey> incomeDetails=(ArrayList<Journey>)adminDao.viewIncome(dateOfJourney);
		return incomeDetails;
	}


	/*
	 * This method return list of passengers of a specified bus on a specified date.
	 * This Method make method call to viewPassengers method located in AdminDao.
	 */
	@RequestMapping(value="view-passengers",method=RequestMethod.POST)
	public ArrayList<Reservation> viewPassengers(@RequestBody Details details)
	{


		ArrayList<Reservation> passengers=(ArrayList<Reservation>)adminDao.viewPassengers(details);
		return passengers;	
	}

	/*
	 * This Method returns total no of buses available between source and destination in a certain time period
	 */
	@RequestMapping(value="total-No-Of-buses",method=RequestMethod.POST)
	public Integer gettotalBuses(@RequestBody NoOfBusesDetails details )
	{

		Integer noOfBuses=busFunctions.getNoOfBuses(details);
		return noOfBuses;	

	}
	@GetMapping("get-busid's")
	public ArrayList<Integer>getBus_IdList()
	{
		return busDao.getBusIdList();
	}
}
