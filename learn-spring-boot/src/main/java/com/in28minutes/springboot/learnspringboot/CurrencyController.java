package com.in28minutes.springboot.learnspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
//@EnableConfigurationProperties(CurrencyServiceConfiguration.class)
public class CurrencyController {
    @Autowired
    private CurrencyServiceConfiguration currencyServiceConfiguration;
    @RequestMapping("/currency")
    public CurrencyServiceConfiguration retrieveAllCourses() {
        return currencyServiceConfiguration;
    }
}
