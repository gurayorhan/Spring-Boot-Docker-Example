package com.websocket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker // enable yapılcak
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

     @Override
    public void registerStompEndpoints(StompEndpointRegistry registry){
         registry.addEndpoint("/chat").setAllowedOrigins("*").withSockJS(); // end point çağırılındığında herkes girer * ile crossdan etkilenmemek için.
         // mesaj chatden alıncak
     }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic");
        // topicden okuncak
    }
}
