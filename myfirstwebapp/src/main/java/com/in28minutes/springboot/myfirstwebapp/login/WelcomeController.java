package com.in28minutes.springboot.myfirstwebapp.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("username")
public class WelcomeController {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private AuthenticationService authenticationService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String goToLoginPage(ModelMap modelMap) {
        modelMap.put("username",userLoggedInName());
        return "welcome";
    }
    private String userLoggedInName(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
//    @RequestMapping(value = "/", method = RequestMethod.POST)
//    public String goToWelcomePage(@RequestParam String username, @RequestParam String password, ModelMap modelMap) {
//        if (authenticationService.authenticate(username, password) == true) {
//            modelMap.put("username", username);
//            modelMap.put("password", password);
//            return "welcome";
//        } else {
//            modelMap.put("err","username or password is invalid");
//            return "login";
//        }
//    }
//    @RequestMapping("/login2")
//    public String goToLoginPage2(@RequestParam String name, ModelMap modelMap) {
//        logger.info("request param is {}",name);
//        modelMap.put("test",name);
//        return "login";
}
