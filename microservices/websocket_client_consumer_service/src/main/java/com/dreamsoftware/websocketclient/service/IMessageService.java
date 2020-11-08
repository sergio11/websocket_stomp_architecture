package com.dreamsoftware.websocketclient.service;

import com.dreamsoftware.websocketclient.domain.MessageDTO;

/**
 *
 * @author ssanchez
 */
public interface IMessageService {

    /**
     *
     * @param messageDTO
     *
     */
    void save(final MessageDTO messageDTO);

}
