package com.dreamsoftware.websocketclient.service.impl;

import com.dreamsoftware.websocketclient.service.IPublishMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import com.dreamsoftware.websocketclient.web.dto.PublishMessageDTO;
import org.springframework.messaging.simp.stomp.StompSession;

/**
 *
 * @author ssanchez
 */
@Service
@RequiredArgsConstructor
public class PublishMessageServiceImpl implements IPublishMessageService {

    /**
     * Stomp Session
     */
    private final StompSession stompSession;

    /**
     *
     * @param message
     */
    @Override
    public void publish(final PublishMessageDTO message) {
        Assert.notNull(message, "Message can not be null");
        stompSession.send("/topic/messages", message);
    }

}
