package com.example.demo.infraestructure;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/")
public class APIHealth {
    
    @GetMapping("")
    public String getAlive() {
        return "ok";
    }
    
}
