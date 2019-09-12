package com.busreservation.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.busreservation.bean.Bus;

public interface BusRepository extends JpaRepository<Bus, Integer>{
	@Query("select bus.bus_id from Bus bus ")
	public ArrayList<Integer> getBusesId();
}
