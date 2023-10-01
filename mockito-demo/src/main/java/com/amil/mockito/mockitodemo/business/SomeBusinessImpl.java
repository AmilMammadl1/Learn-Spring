package com.amil.mockito.mockitodemo.business;

public class SomeBusinessImpl {
	private DataService dataService;
	public SomeBusinessImpl(DataService dataService) {
		this.dataService=dataService;
	}

	public int findTheGreatestFromAllData() {
		int[] data = dataService.retrieveallData();
		int greatestValue = Integer.MIN_VALUE;
		for(int value: data) {
			if(value>greatestValue) {
				greatestValue=value;
			}
		}
		return greatestValue;
	}
}
interface DataService{
	int[] retrieveallData();
}