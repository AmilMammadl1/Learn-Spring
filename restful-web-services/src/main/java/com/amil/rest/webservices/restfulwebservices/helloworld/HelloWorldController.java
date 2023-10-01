package com.amil.rest.webservices.restfulwebservices.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContext;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
public class HelloWorldController {
//    @RequestMapping(method = RequestMethod.GET,path = "/hello")
    @Autowired
    private MessageSource messageSource;
    @GetMapping(path = "/hello-world")
    public String helloWorld(){
        return "Hello Mr.Amil";
    }

    @GetMapping("/hello-world-bean")
    public HelloWorldbean helloWorldBean(){
        return new HelloWorldbean("Amil");
    }
    @GetMapping("/hello-world/path-variable/{name}")
    public HelloWorldbean helloWorldPathVariable(@PathVariable String name){
        return new HelloWorldbean("welcome: "+name);
    }
    @GetMapping("/hello-world-internationalized")
    public String helloWorldInternationalized(){
        Locale locale = LocaleContextHolder.getLocale();
         return messageSource.getMessage("good.morning.message",null,"Default Message",locale);
//        return "Good Morning";
    }

}
