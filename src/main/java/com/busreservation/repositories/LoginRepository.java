package com.busreservation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.busreservation.bean.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, String> {
			@Query("Select login from Login login where login.username=?1 and login.password=?2")
			public Login getUserDetails(String username,String password);
}
