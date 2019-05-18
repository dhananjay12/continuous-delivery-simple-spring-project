package com.mynotes.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MyController {

    @Value("${message.text")
    private String msg;

    @GetMapping(value = "/msg")
    public ResponseEntity<?> msg(){
        return ResponseEntity.ok(msg);
    }

    @GetMapping(value = "/hello/{name}")
    public ResponseEntity<?> hello(@PathVariable String name){
        return ResponseEntity.ok("Hello "+name);
    }

    @GetMapping(value = "/add")
    public ResponseEntity<?> hello(@RequestParam int num1,@RequestParam int num2){
        int result=num1+num2;
        return ResponseEntity.ok(result);
    }

}
