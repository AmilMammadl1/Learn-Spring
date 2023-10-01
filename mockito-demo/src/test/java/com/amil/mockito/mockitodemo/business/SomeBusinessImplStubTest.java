package com.amil.mockito.mockitodemo.business;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SomeBusinessImplStubTest {
	DataServiceStub dataServiceStub = new DataServiceStub();
	SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceStub);

	@Test
	void test() {
		int result = businessImpl.findTheGreatestFromAllData();
		System.out.println(result);
	}

}
class DataServiceStub implements DataService{

	@Override
	public int[] retrieveallData() {
		// TODO Auto-generated method stub
		return new int[] {1,2,3,4,99,6};
	}
	
}
