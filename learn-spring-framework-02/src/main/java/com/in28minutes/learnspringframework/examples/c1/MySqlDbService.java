package com.in28minutes.learnspringframework.examples.c1;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Component
@Repository
public class MySqlDbService implements DataService {
    @Override
    public int[] retrieveData() {
        return new int[] {11,22,33,44,55};    }
}
