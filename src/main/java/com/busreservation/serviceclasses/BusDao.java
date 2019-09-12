package com.busreservation.serviceclasses;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.busreservation.repositories.BusRepository;

@Service
public class BusDao {
	@Autowired
	BusRepository busRepository;
	public ArrayList<Integer> getBusIdList()
	{
		return busRepository.getBusesId();
		
	}
	
}
