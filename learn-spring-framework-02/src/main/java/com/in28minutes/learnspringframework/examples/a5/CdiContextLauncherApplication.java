package com.in28minutes.learnspringframework.examples.a5;

import com.in28minutes.learnspringframework.examples.c1.DataService;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

//@Component
@Named
class BusinessServicee {
    private DataService2 dataService;

    public BusinessServicee(DataService2 dataService) {
        System.out.println("test3");
        this.dataService = dataService;
    }

    public DataService2 getDataService() {
        System.out.println("test1");
        return dataService;
    }

    //@Autowired
    //@Inject
    public void setDataService(DataService2 dataService) {
        System.out.println("test2");
        this.dataService = dataService;
    }
}

//@Component
@Named
class DataService2 {

}

@Configuration
@ComponentScan()
public class CdiContextLauncherApplication {
    public static void main(String[] args) {

        try (var context = new AnnotationConfigApplicationContext(CdiContextLauncherApplication.class)) {
            System.out.println(context.getBean(BusinessServicee.class).getDataService());
        }
    }
}
