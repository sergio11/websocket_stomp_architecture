package com.dreamsoftware.websocketserver.service.impl;

import com.dreamsoftware.websocketserver.service.IPublishMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import com.dreamsoftware.websocketserver.web.dto.PublishMessageDTO;

/**
 *
 * @author ssanchez
 */
@Service
@RequiredArgsConstructor
public class PublishMessageServiceImpl implements IPublishMessageService {

    /**
     * Messaging Template
     */
    private final SimpMessagingTemplate messagingTemplate;

    /**
     *
     * @param message
     */
    @Override
    public void publish(final PublishMessageDTO message) {
        Assert.notNull(message, "Message can not be null");
        messagingTemplate.convertAndSend("/topic/messages", message);
    }

}
