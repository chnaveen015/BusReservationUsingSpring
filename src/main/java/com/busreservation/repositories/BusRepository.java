package com.busreservation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.busreservation.bean.Bus;
@Repository
public interface BusRepository extends JpaRepository<Bus, Integer> {

}
