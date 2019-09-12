package com.busreservation.bean;

import javax.persistence.Entity; 
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity(name="SeatAvailable")
@Table(name = "SeatAvailable")
public class SeatAvailable {
	@Id
	private int id;
	@NotNull
	private int available_seats;
	@ManyToOne
	@JoinColumn(name="journey_id")
	private Journey journey;
	@ManyToOne
	@JoinColumn(name="routeno")
	private TicketCost ticketCost;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAvailiable_seats() {
		return available_seats;
	}
	public void setAvailiable_seats(int available_seats) {
		this.available_seats = available_seats;
	}
	public Journey getJourney() {
		return journey;
	}
	public void setJourney(Journey journey) {
		this.journey = journey;
	}
	public TicketCost getTicketCost() {
		return ticketCost;
	}
	public void setTicketCost(TicketCost ticketCost) {
		this.ticketCost = ticketCost;
	}
	@Override
	public String toString() {
		return "SeatAvailable [id=" + id + ", available_seats=" + available_seats + ", journey=" + journey
				+ ", ticketCost=" + ticketCost + "]";
	}



}