package com.viswa.mockito.mockitodemo.somebusiness;

public class SomeBusinessImpl {

	private DataService dataService;
	
	public SomeBusinessImpl(DataService dataService) {
		super();
		this.dataService = dataService;
	}


	public int findTheGreatesOfAllData() {
		int[] data = dataService.retrieveAllData();
		int greatestValue = Integer.MIN_VALUE;
		for(int value:data) {
			if(value > greatestValue) {
				greatestValue = value;
			}
		}
		return greatestValue;
	}
}

interface DataService {
	int[] retrieveAllData();
}