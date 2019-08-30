package com.busreservation.serviceclasses;

import java.sql.Date;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.busreservation.bean.BusDetails;
import com.busreservation.bean.Journey;
import com.busreservation.bean.NoOfBusesDetails;
import com.busreservation.repositories.JourneyRepository;

@Service
public class JourneyDao {
		@Autowired
		JourneyRepository journeyRepo;
		public ArrayList<Journey> getJourney(BusDetails busDetails)
		{	
			return journeyRepo.getJourneyDetails(busDetails.getJourney_date(),busDetails.getBus_id());
			
		}
		
		public Integer increaseCost(int fare, int journey_id) {
			// TODO Auto-generated method stub
			Journey journey=journeyRepo.findById(journey_id).get();
			journey.setCost(journey.getCost()+fare);
			journeyRepo.save(journey);
			return journey.getCost();
		}

		public Journey getJourneyDetails(Integer journey_id) {
			// TODO Auto-generated method stub
			return journeyRepo.findById(journey_id).get();
		}

		public Integer duductCost(int fare, int journey_id) {
			// TODO Auto-generated method stub
			Journey journey=journeyRepo.findById(journey_id).get();
			journey.setCost(journey.getCost()-fare);
			journeyRepo.save(journey);
			return journey.getCost();
		}

		public int getBusCount(BusDetails busDetails, NoOfBusesDetails details) {
			// TODO Auto-generated method stub
			return journeyRepo.getNoOfBuses(Date.valueOf(details.getStartDate()),Date.valueOf(details.getEndDate()),busDetails.getBus_id()).size();
		}
		
		
		
}
