package com.busreservation.businessclasses;

import java.util.Random;

import org.springframework.stereotype.Component;
@Component
public class PnrGeneration {
	public Integer getPnr() {
		// TODO Auto-generated method stub
		Random reservationBean = new Random();
		Integer pnr = reservationBean.nextInt(60000) + 100000;
		return pnr;
	}
}
