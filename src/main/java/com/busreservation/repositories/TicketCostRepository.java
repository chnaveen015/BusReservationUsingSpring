package com.busreservation.repositories;

import java.util.ArrayList; 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.busreservation.bean.BasicDetailsBean;
import com.busreservation.bean.Details;
import com.busreservation.bean.TicketCost;
@Repository
public interface TicketCostRepository extends JpaRepository<TicketCost, Integer>{
	
	
	@Query("SELECT DISTINCT t.source from TicketCost t")	
	public ArrayList<String> getSources();
	
	@Query("SELECT DISTINCT t.destination from TicketCost t")
	public ArrayList<String> getDestinations();
	
	@Query("SELECT t from TicketCost t where t.source=:source order by t.routeno")
	public ArrayList<TicketCost>getSourcesList(@Param("source") String source);
	
	@Query("SELECT t from TicketCost t where t.destination=:destination order by t.routeno")
	public ArrayList<TicketCost> getDestinationList(@Param("destination") String destination);
	
	@Query("select sum(ticket.fare) from TicketCost ticket where (ticket.routeno>=:routeno1 and ticket.routeno<=:routeno2)")
	public Long getFare(@Param("routeno1") int routeno1,@Param("routeno2") int routeno2);
	
	@Modifying
	@Query("update Journey set total_cost=total_cost+?1 where journey_id=?2")
	public Integer updateBusTotalCost(int fare,int journey_id);
	
}
	