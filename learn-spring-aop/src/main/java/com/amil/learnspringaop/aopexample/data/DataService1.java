package com.amil.learnspringaop.aopexample.data;

import com.amil.learnspringaop.aopexample.annotations.TrackTime;
import org.springframework.stereotype.Repository;

@Repository
public class DataService1 {
    @TrackTime
    public int[] retrieveData() throws InterruptedException {
        Thread.sleep(100);
        return new int[] {1,2,3,4,5,};
    }
}
