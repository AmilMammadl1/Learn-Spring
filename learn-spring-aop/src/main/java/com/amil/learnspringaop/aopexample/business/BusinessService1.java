package com.amil.learnspringaop.aopexample.business;

import com.amil.learnspringaop.aopexample.annotations.TrackTime;
import com.amil.learnspringaop.aopexample.data.DataService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
@Service
public class BusinessService1 {
    @Autowired
    private DataService1 dataService1;
    @TrackTime
    public int calculateMax() throws InterruptedException {
        int[] data = dataService1.retrieveData();
//        throw new RuntimeException("selam beybiiii");
        Thread.sleep(100);
        return Arrays.stream(data).max().orElse(0);
    }
}
