package com.xc.example.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Ceshi {

    @GetMapping("/demo")
    public String  demo(){
        return "success";
    }
}
