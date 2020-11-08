package com.dreamsoftware.websocketclient.handler;

import java.lang.reflect.Type;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;
import com.dreamsoftware.websocketclient.web.dto.PublishMessageDTO;

/**
 *
 * @author ssanchez
 */
public class WebSocketStompSessionHandler extends StompSessionHandlerAdapter {

    private Logger logger = LoggerFactory.getLogger(WebSocketStompSessionHandler.class);

    /**
     * On After Connected
     *
     * @param session
     * @param connectedHeaders
     */
    @Override
    public void afterConnected(StompSession session, StompHeaders connectedHeaders) {
        logger.info("New session established : " + session.getSessionId());
    }

    /**
     *
     * @param session
     * @param command
     * @param headers
     * @param payload
     * @param exception
     */
    @Override
    public void handleException(StompSession session, StompCommand command, StompHeaders headers, byte[] payload, Throwable exception) {
        logger.error("Got an exception", exception);
    }

    @Override
    public Type getPayloadType(StompHeaders headers) {
        return PublishMessageDTO.class;
    }

    /**
     *
     * @param headers
     * @param payload
     */
    @Override
    public void handleFrame(StompHeaders headers, Object payload) {
        logger.error("on handleFrame CALLED");

    }
}
