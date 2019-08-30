package com.busreservation.repositories;

import java.sql.Date;
import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.busreservation.bean.Journey;
@Repository
public interface JourneyRepository extends JpaRepository<Journey, Integer>{
		@Query("select journey from Journey journey where journey.journey_date =:date and bus_id =:bus_id")
		public ArrayList<Journey> getJourneyDetails(@Param("date") Date date,@Param("bus_id") int bus_id);
		
		@Query("update Journey set total_cost=total_cost+?1 where journey_id=?2")
		public Integer updateBusTotalCost(int fare,int journey_id);
		
		@Query("select busdetails from Journey busdetails where journey_date=?1")
		public ArrayList<Journey> getIncomDetails(Date date);
		
		@Query("select journey from Journey journey where journey.journey_date >=?1 and journey.journey_date<=?2 and bus_id =?3")
		public ArrayList<Journey> getNoOfBuses(Date startDate,Date endDate,int bus_id);
}
