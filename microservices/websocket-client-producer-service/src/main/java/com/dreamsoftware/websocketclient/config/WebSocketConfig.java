package com.dreamsoftware.websocketclient.config;

import com.dreamsoftware.websocketclient.handler.WebSocketStompSessionHandler;
import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.simp.stomp.StompSessionHandler;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;

/**
 *
 * @author ssanchez
 */
@Configuration
@RequiredArgsConstructor
public class WebSocketConfig {

    private static final Logger logger = LoggerFactory.getLogger(WebSocketConfig.class);

    /**
     * Provide Stomp Session Handler
     *
     * @return
     */
    @Bean
    protected StompSessionHandler provideStompSessionHandler() {
        return new WebSocketStompSessionHandler();
    }

    /**
     * Provide Web Socket Client
     *
     * @param sessionHandler
     * @return
     */
    @Bean
    protected WebSocketClient provideWebSocketClient(final StompSessionHandler sessionHandler) {
        final WebSocketClient client = new StandardWebSocketClient();
        final WebSocketStompClient stompClient = new WebSocketStompClient(client);
        stompClient.setMessageConverter(new MappingJackson2MessageConverter());
        stompClient.connect("ws://localhost:8080/messages", sessionHandler);
        return client;
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
