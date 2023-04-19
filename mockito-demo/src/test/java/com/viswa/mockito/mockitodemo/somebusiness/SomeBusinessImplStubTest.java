package com.viswa.mockito.mockitodemo.somebusiness;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SomeBusinessImplStubTest {

	@Test
	void findtheGreatestOfAll_basicScenario() {
		DataServiceStub dataServiceStub = new DataServiceStub();
		SomeBusinessImpl somebusiness = new SomeBusinessImpl(dataServiceStub);
		int result = somebusiness.findTheGreatesOfAllData();
		assertEquals(25, result);
	}
	
	@Test
	void findtheGreatestOfAll_stub1Scenario() {
		DataServiceStub1 dataServiceStub1 = new DataServiceStub1();
		SomeBusinessImpl somebusiness = new SomeBusinessImpl(dataServiceStub1);
		int result = somebusiness.findTheGreatesOfAllData();
		assertEquals(5, result);
	}

}

class DataServiceStub implements DataService{

	@Override
	public int[] retrieveAllData() {
		// TODO Auto-generated method stub
		return new int[] {25,16,5};
	}
	
}

class DataServiceStub1 implements DataService{

	@Override
	public int[] retrieveAllData() {
		// TODO Auto-generated method stub
		return new int[] {-1,-8,5};
	}
	
}
