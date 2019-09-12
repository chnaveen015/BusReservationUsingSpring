package com.busreservation.serviceclasses;

import java.util.ArrayList; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.busreservation.bean.BusDetails;
import com.busreservation.bean.Reservation;
import com.busreservation.bean.SeatAvailable;
import com.busreservation.repositories.SeatAvailbaleRepository;

@Service
public class SeatAvailableDao {
	@Autowired
	SeatAvailbaleRepository seatAvailableRepo;
	@Autowired
	SeatAvailableDao seatAvaibleDao;

	public Integer getAvailableSeats(BusDetails details)
	{
		return seatAvailableRepo.getAvailableSeats(details.getJourney_id(), details.getRouteno1(), details.getRouteno2());
	}

	public Integer decreaseNoOfSeats(Reservation reservationDetails)
	{

		ArrayList<SeatAvailable> seatsDetails= seatAvailableRepo.updateSeats(reservationDetails.getJourney().getJourney_id(),reservationDetails.getStopno1(),reservationDetails.getStopno2());
		for(SeatAvailable seatDetail:seatsDetails)
		{
			seatDetail.setAvailiable_seats(seatDetail.getAvailiable_seats()-reservationDetails.getNo_of_seats());
			seatAvaibleDao.updateSeatsDetails(seatDetail);
		}
		return seatsDetails.size();
	}
	public void updateSeatsDetails(SeatAvailable seats)
	{
		seatAvailableRepo.save(seats);
	}

	public Integer increaseNoOfSeats(Reservation reservationDetails) {

		ArrayList<SeatAvailable> seatsDetails= seatAvailableRepo.updateSeats(reservationDetails.getJourney().getJourney_id(),reservationDetails.getStopno1(),reservationDetails.getStopno2());
		for(SeatAvailable seatDetail:seatsDetails)
		{
			seatDetail.setAvailiable_seats(seatDetail.getAvailiable_seats()+reservationDetails.getNo_of_seats());
			seatAvaibleDao.updateSeatsDetails(seatDetail);
		}
		return seatsDetails.size();
	}
}
