package com.restaurantservice.controller;

import com.restaurantservice.dto.OrderResponseDTO;
import com.restaurantservice.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/greeting")
    public String greetingMessage(){
        return restaurantService.greeting();
    }

    @GetMapping("/order/{orderId}")
    public OrderResponseDTO getOrder(@PathVariable String orderId){
        return restaurantService.getOrder(orderId);
    }

    @GetMapping("/order/status/{orderId}")
    public String getOrderStatus(@PathVariable String orderId){
        return restaurantService.getOrderStatus(orderId);
    }
}
