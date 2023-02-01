package com.org.myapp.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ConfigUIController {

    @GetMapping("/")
    public String root(){
        return "redirect:/index.html";
    }

//    @GetMapping("/ui")
//    public String rootUi(){
//        return "redirect:/ui/index.html";
//    }

}
