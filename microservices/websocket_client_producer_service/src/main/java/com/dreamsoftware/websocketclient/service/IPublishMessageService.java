package com.dreamsoftware.websocketclient.service;

import com.dreamsoftware.websocketclient.web.dto.PublishMessageDTO;

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
