package com.example.SpringBootProject.APPController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class APPController {
@GetMapping("/temperature/{color}")
    public String temperature(@PathVariable String color,
                              @RequestParam(required = false) Integer i,
                              Model tempr) {
        tempr.addAttribute("tempr", i);
        tempr.addAttribute("color", color);
        return "temperature.html";
    }
}