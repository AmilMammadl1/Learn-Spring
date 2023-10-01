package com.amil.mockito.mockitodemo.business;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


import org.junit.jupiter.api.Test;

class SomeBusinessImplMockTest {


	@Test
	void test() {
		DataService dataServiceMock = mock(DataService.class);
		when(dataServiceMock.retrieveallData()).thenReturn(new int[] {1,2,3,4,99,6});
		SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceMock);
		int result = businessImpl.findTheGreatestFromAllData();
		System.out.println(result);
	}

}
