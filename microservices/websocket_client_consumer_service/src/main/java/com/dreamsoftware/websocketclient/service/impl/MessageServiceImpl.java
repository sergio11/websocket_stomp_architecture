package com.dreamsoftware.websocketclient.service.impl;

import com.dreamsoftware.websocketclient.service.IMessageService;
import org.springframework.stereotype.Service;
import com.dreamsoftware.websocketclient.domain.MessageDTO;
import com.dreamsoftware.websocketclient.mapper.MessageMapper;
import com.dreamsoftware.websocketclient.persistence.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.util.Assert;
import com.dreamsoftware.websocketclient.persistence.entity.MessageEntity;

/**
 *
 * @author ssanchez
 */
@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements IMessageService {

    private final MessageRepository messageRepository;
    private final MessageMapper messageMapper;

    /**
     *
     * @param messageDTO
     */
    @Override
    public void save(final MessageDTO messageDTO) {
        Assert.notNull(messageDTO, "Message can not be null");
        final MessageEntity messageEntity = messageMapper.dtoToEntity(messageDTO);
        messageRepository.save(messageEntity);
    }

}
