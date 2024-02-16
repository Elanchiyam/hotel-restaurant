package com.restaurantservice.service;

import com.restaurantservice.dao.RestaurantOrderDAO;
import com.restaurantservice.dto.OrderResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantOrderDAO restaurantOrderDAO;

    public String greeting(){
        return "Welcome to Swiggy App restaurant Service";
    }

    public OrderResponseDTO getOrder(String orderId){
        return restaurantOrderDAO.getOrders(orderId);
    }

    public String getOrderStatus(String orderId){
        return restaurantOrderDAO.getOrders(orderId).getStatus();
    }
}
