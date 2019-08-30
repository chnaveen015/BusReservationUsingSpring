package com.busreservation.serviceclasses;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.busreservation.bean.Reservation;
import com.busreservation.repositories.ReservationRepository;

@Service
public class ReservationDao {
		@Autowired
		ReservationRepository reservationRepo;
		@Autowired
		Reservation reservation;
		public Optional<Reservation> viewTicket(Integer pnr)
		{
			
			return reservationRepo.findById(pnr);
			
		}
	
	public Reservation insertTicketDetails(Reservation reserveTicket) {
		return reservationRepo.save(reserveTicket);
	}

	public Object removeTicketDetails(Reservation cancelTicket) {
		// TODO Auto-generated method stub
		System.out.println("hello");
		reservationRepo.delete(cancelTicket);
		return "yes";
	}
	
}
