package com.dreamsoftware.websocketserver.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 *
 * @author ssanchez
 */
@Data
@Component
public class StompBrokerRelayProps {

    /**
     * Broker Relay Prefix
     */
    @Value("${stomp.prefix}")
    private String prefix;

    /**
     * Broker Relay Host
     */
    @Value("${stomp.host}")
    private String host;

    /**
     * Broker Relay Port
     */
    @Value("${stomp.port}")
    private int port;

    /**
     * Broker Relay Client Username
     */
    @Value("${stomp.client.username}")
    private String clientUsername;

    /**
     * Broker Relay Client Passcode
     */
    @Value("${stomp.client.passcode}")
    private String clientPasscode;

}
