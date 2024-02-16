package com.swiggyapp.controller;

import com.swiggyapp.service.SwiggyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/swiggy")
public class SwiggyAppController {

    @Autowired
    private SwiggyService service;

    @GetMapping("/greeting")
    private String greetingMessage(){
        return service.greetingMessage();
    }

    @GetMapping("/order/status/{orderId}")
    private String checkOrderStatus(@PathVariable String orderId,@RequestHeader("loggedInUser") String username){
        System.out.println("Logged in user details : - " + username);
        return service.checkOrderStatus(orderId);
    }

}
