package com.homework2.demo.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@ResponseBody
public class HomeController {

    @GetMapping("/")
    public String Hello(){
        return  "Welecome";

    }



}
