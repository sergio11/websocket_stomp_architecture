package com.dreamsoftware.websocketserver.config;

import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 *
 * @author ssanchez
 */
@Configuration
@EnableWebSocketMessageBroker
@RequiredArgsConstructor
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    private static final Logger logger = LoggerFactory.getLogger(WebSocketConfig.class);

    /**
     * Broker Relay Properties
     */
    private StompBrokerRelayProps brokerRelayProps;

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry
                .enableStompBrokerRelay("/queue", "/topic")
                .setUserDestinationBroadcast("/topic/unresolved.user.dest")
                .setUserRegistryBroadcast("/topic/registry.broadcast")
                .setRelayHost("localhost")
                .setRelayPort(61613)
                .setClientLogin("guest")
                .setClientPasscode("guest")
                .setSystemLogin("guest")
                .setSystemPasscode("guest");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/messages").setAllowedOrigins("*");
        registry.addEndpoint("/messages").setAllowedOrigins("*").withSockJS();
    }

    @PostConstruct
    protected void onInit() {
        //logger.debug("Stomp Prefix -> " + brokerRelayProps.getPrefix());
        //logger.debug("Stomp Host -> " + brokerRelayProps.getHost());
        //logger.debug("Stomp Port -> " + brokerRelayProps.getPort());
        //logger.debug("Stomp Client Username -> " + brokerRelayProps.getClientUsername());
        //logger.debug("Stomp Client Passcode -> " + brokerRelayProps.getClientPasscode());

    }
}
