package com.viswa.mockito.mockitodemo.somebusiness;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SomeBusinessImplMockTest {

	@Mock
	private DataService dataServiceMock;
	
	@InjectMocks
	private SomeBusinessImpl businessImpl;
	
	@Test
	void findtheGreatestOfAll_basicScenario() {
		when (dataServiceMock.retrieveAllData()).thenReturn(new int[] {25, 16, 3});
		assertEquals(25, businessImpl.findTheGreatesOfAllData());
	}
	
	@Test
	void findtheGreatestOfAll_oneValue() {
		//DataService dataServiceMock = mock(DataService.class);
		when (dataServiceMock.retrieveAllData()).thenReturn(new int[] {12});
		//SomeBusinessImpl somebusiness = new SomeBusinessImpl(dataServiceMock);
		assertEquals(12, businessImpl.findTheGreatesOfAllData());
	}
	
	@Test
	void findtheGreatestOfAll_emptyValue() {
		//DataService dataServiceMock = mock(DataService.class);
		when (dataServiceMock.retrieveAllData()).thenReturn(new int[] {});
		//SomeBusinessImpl somebusiness = new SomeBusinessImpl(dataServiceMock);
		assertEquals(Integer.MIN_VALUE, businessImpl.findTheGreatesOfAllData());
	}
	

}


