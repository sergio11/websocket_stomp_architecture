package com.dreamsoftware.websocketserver.service;

import com.dreamsoftware.websocketserver.web.dto.PublishMessageDTO;

/**
 *
 * @author ssanchez
 */
public interface IPublishMessageService {

    /**
     * Publish
     *
     * @param message
     */
    void publish(final PublishMessageDTO message);
}
