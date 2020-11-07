package com.dreamsoftware.websocketclient.service.impl;

import com.dreamsoftware.websocketclient.service.IPublishMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import com.dreamsoftware.websocketclient.web.dto.PublishMessageDTO;

/**
 *
 * @author ssanchez
 */
@Service
@RequiredArgsConstructor
public class PublishMessageServiceImpl implements IPublishMessageService {

    /**
     *
     * @param message
     */
    @Override
    public void publish(final PublishMessageDTO message) {
        Assert.notNull(message, "Message can not be null");
        //messagingTemplate.convertAndSend("/topic/message", message);
    }

}
