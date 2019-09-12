package com.busreservation.serviceclasses;

import java.sql.Date;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.busreservation.bean.Details;
import com.busreservation.bean.Journey;
import com.busreservation.bean.Reservation;
import com.busreservation.repositories.JourneyRepository;
import com.busreservation.repositories.ReservationRepository;



@Service
public class AdminDao {
	@Autowired
	JourneyRepository journeyRepo;
	@Autowired
	ReservationRepository reservatioRepo;

	public ArrayList<Journey> viewIncome(String dateOfJourney) {
		

		return journeyRepo.getIncomDetails(Date.valueOf(dateOfJourney));
	}

	public ArrayList<Reservation> viewPassengers(Details details) {
	
		return reservatioRepo.getPassengers(details.getDate(),details.getBus_id());
	}

}
