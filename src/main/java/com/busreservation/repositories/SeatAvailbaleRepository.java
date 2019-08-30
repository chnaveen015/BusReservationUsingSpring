package com.busreservation.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.busreservation.bean.SeatAvailable;
@Repository
public interface SeatAvailbaleRepository extends JpaRepository<SeatAvailable, Integer> {
		@Query("select min(seat.available_seats) from SeatAvailable seat where journey_id=:journey_id and (routeno>=:routeno1 and routeno<=:routeno2)")
		public Integer getAvailableSeats(@Param("journey_id") int journey_id,@Param("routeno1") int routeno1,@Param("routeno2") int routeno2);
		
	
		@Query("Select seatDetails From SeatAvailable seatDetails where journey_id=?1 and (routeno>=?2 and routeno<=?3)")
		public ArrayList<SeatAvailable> updateSeats(int journey_id,int routeno1,int routeno2);	
}
