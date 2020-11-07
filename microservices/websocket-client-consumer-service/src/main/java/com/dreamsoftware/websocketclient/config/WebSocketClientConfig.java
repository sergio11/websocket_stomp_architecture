package com.dreamsoftware.websocketclient.config;

import com.dreamsoftware.websocketclient.handler.WebSocketStompSessionHandler;
import java.util.concurrent.ExecutionException;
import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.simp.stomp.StompSession;
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
public class WebSocketClientConfig {

    private static final Logger logger = LoggerFactory.getLogger(WebSocketClientConfig.class);

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
     * Provide WebSocket Client
     *
     * @return
     */
    @Bean
    protected WebSocketClient provideWebSocketClient() {
        return new StandardWebSocketClient();
    }

    /**
     * Provide StompSession session
     *
     * @param sessionHandler
     * @param webSocketClient
     * @return
     * @throws java.lang.InterruptedException
     * @throws java.util.concurrent.ExecutionException
     */
    @Bean
    protected StompSession provideStompSession(
            final StompSessionHandler sessionHandler,
            final WebSocketClient webSocketClient
    ) throws InterruptedException, ExecutionException {
        final WebSocketStompClient stompClient = new WebSocketStompClient(webSocketClient);
        stompClient.setMessageConverter(new MappingJackson2MessageConverter());
        return stompClient.connect("ws://localhost:8080/messages", sessionHandler).get();
    }
}
