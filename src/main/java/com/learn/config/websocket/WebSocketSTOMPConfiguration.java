//package com.learn.config.websocket;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
//import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
//import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurationSupport;
//import org.springframework.web.socket.config.annotation.WebSocketTransportRegistration;
//
//@Configuration
//@EnableWebSocketMessageBroker
//public class WebSocketSTOMPConfiguration extends WebSocketMessageBrokerConfigurationSupport {
//
//    @Override
//    protected void registerStompEndpoints(StompEndpointRegistry registry) {
//        registry.addEndpoint("/ws").withSockJS();
//    }
//
////    @Override
////    protected void configureMessageBroker(MessageBrokerRegistry registry) {
////        registry.enableSimpleBroker("/topic");
////        registry.setUserDestinationPrefix("/app");
////    }
//
//
//    @Override
//    protected void configureWebSocketTransport(WebSocketTransportRegistration registry) {
//        registry.setSendBufferSizeLimit(1024 * 1024);
//        registry.setMessageSizeLimit(1024 * 1024);
//    }
//}
