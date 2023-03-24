package com.example.SBProject17.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
@RequestMapping("/temperature")
    public String temperature (Model temp){
        temp.addAttribute("color", "red");
        temp.addAttribute("tempr", "15");
        return "temperature.html";
    }
}
