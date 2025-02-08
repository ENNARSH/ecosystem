package com.ecosystem.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        // Configura il broker per i messaggi
        config.enableSimpleBroker("/topic", "/queue"); // Destinazioni a cui il client si iscriverà
        config.setApplicationDestinationPrefixes("/app"); // Prefisso per i messaggi diretti
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // Endpoint che il client userà per connettersi al WebSocket
        registry.addEndpoint("/chat").withSockJS(); // Abilita SockJS per fallback in caso di errori
    }
}
