package com.swiggyapp.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class RestaurantServiceClient {

    @Autowired
    private RestTemplate template;

    public String fetchOrderStatusWithRestTemplate(String orderId){
        return template.getForObject("http://RESTAURANT-SERVICE/restaurant/order/status/"+orderId,String.class);
    }

    //    USING WEB_CLIENT
    @Autowired
    private WebClient.Builder webClientBuilder;

    public String fetchOrderStatusWithWebClient(String orderId){
        String orderStatus = webClientBuilder.build().get().uri("http://RESTAURANT-SERVICE/restaurant/order/status/"+ orderId).retrieve().bodyToMono(String.class).block();
        return orderStatus;
    }
}
