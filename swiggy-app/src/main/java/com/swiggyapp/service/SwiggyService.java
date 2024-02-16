package com.swiggyapp.service;

import com.swiggyapp.client.RestaurantServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SwiggyService {

    @Autowired
    private RestaurantServiceClient client;
    public String greetingMessage(){
        return "Welcome to Swiggy App Service";
    }

    public String checkOrderStatus(String orderId) {
//        return client.fetchOrderStatusWithRestTemplate(orderId);
        return client.fetchOrderStatusWithWebClient(orderId);
    }
}
