package com.busreservation.repositories;

import java.util.ArrayList;  

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.busreservation.bean.TicketCost;
@Repository
public interface TicketCostRepository extends JpaRepository<TicketCost, Integer>{

	/*
	 * This method returns lists of available Source list.
	 */
	@Query("SELECT DISTINCT t.source from TicketCost t")	
	public ArrayList<String> getSources();

	/*
	 * This method returns  list of available destination list.
	 */
	@Query("SELECT DISTINCT t.destination from TicketCost t")
	public ArrayList<String> getDestinations();

	/*
	 * This method returns the list of sources list based on the source
	 */
	@Query("SELECT t from TicketCost t where t.source=:source order by t.routeno")
	public ArrayList<TicketCost>getSourcesList(@Param("source") String source);

	/* 
	 * This method returns the list of available destination list based on the destination.
	 */
	@Query("SELECT t from TicketCost t where t.destination=:destination order by t.routeno")
	public ArrayList<TicketCost> getDestinationList(@Param("destination") String destination);

	/*
	 * This method returns the fare details by taking inputs(routeno1 and routeno2)
	 */
	@Query("select sum(ticket.fare) from TicketCost ticket where (ticket.routeno>=:routeno1 and ticket.routeno<=:routeno2)")
	public Long getFare(@Param("routeno1") int routeno1,@Param("routeno2") int routeno2);



}
