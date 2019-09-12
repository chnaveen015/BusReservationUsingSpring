package com.busreservation.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.busreservation.bean.Login;
import com.busreservation.serviceclasses.LoginDao;

@RestController
@RequestMapping("LoginResource")
public class LoginResource {
	@Autowired
	LoginDao loginDao;

	/*
	 * This method returns whether entered details are valid or invalid.
	 */
	@RequestMapping(value="/GetAuthorizationStatus",method=RequestMethod.POST)
	public String getLoginStatus(@RequestBody Login login)
	{
		Login user=loginDao.getLoginCredentials(login);
		if(user!=null)
			return "valid";
		else 
			return "invalid" ;

	}

}
