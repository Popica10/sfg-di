package com.example.sfgdi.controller;

import org.springframework.stereotype.Controller;

@Controller
public class MyController {

    public String helloWorld(){
        System.out.println("Hello, I've just arrived");
        return "Would you like a cup of coffee";
    }

}
