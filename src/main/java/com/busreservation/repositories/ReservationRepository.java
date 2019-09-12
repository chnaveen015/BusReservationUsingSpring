package com.busreservation.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.busreservation.bean.Reservation;
@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer>{

	/* 
	 * This method returns list of passengers details based on the date and bus_id.
	 */
	@Query("select passengers from Reservation passengers where passengers.dateOfJourney=?1 and bus_id=?2")
	public ArrayList<Reservation> getPassengers(String date,int bus_id);

}
