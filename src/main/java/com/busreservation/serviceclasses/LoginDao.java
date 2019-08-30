package com.busreservation.serviceclasses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.busreservation.bean.Login;
import com.busreservation.repositories.LoginRepository;

@Service
public class LoginDao {
		@Autowired
		LoginRepository loginRepo;

		public Login getLoginCredentials(Login login) {
			// TODO Auto-generated method stub
			return loginRepo.getUserDetails(login.getUsername(),login.getPassword());
		}
	
}
