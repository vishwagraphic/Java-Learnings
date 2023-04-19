package com.viswa.learnspringaop.aopexample.business;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.viswa.learnspringaop.aopexample.data.DataService1;

@Service
public class BusinessService1 {

	private DataService1 dataService1;
	
	
	
	public BusinessService1(DataService1 dataService1) {
		super();
		this.dataService1 = dataService1;
	}


	public int calculateMax() {
		int[] data = dataService1.retrieveData();
		try {
			Thread.sleep(0);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//throw new RuntimeException("Something Went Wrong");
		return Arrays.stream(data).max().orElse(0);
	}
}
