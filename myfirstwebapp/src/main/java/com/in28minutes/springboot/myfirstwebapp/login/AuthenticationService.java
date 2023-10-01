package com.in28minutes.springboot.myfirstwebapp.login;

import org.springframework.stereotype.Service;

import java.util.stream.Stream;
@Service
public class AuthenticationService {
    public boolean authenticate(String username, String password) {
        boolean isValidUserName = username.equalsIgnoreCase("amil");
        boolean isValidUserPassword = password.equalsIgnoreCase("amil2003");
        if (isValidUserName == true && isValidUserPassword == true) {
            return true;
        }
        else {
            return false;
        }
    }
}
