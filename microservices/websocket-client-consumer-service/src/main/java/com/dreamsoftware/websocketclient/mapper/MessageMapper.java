package com.dreamsoftware.websocketclient.mapper;

import java.util.List;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import com.dreamsoftware.websocketclient.persistence.entity.MessageEntity;
import com.dreamsoftware.websocketclient.domain.MessageDTO;

/**
 *
 * @author ssanchez
 */
@Mapper(unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public abstract class MessageMapper {

    /**
     *
     * @param messageDTO
     * @return
     */
    @Mappings({})
    @Named("dtoToEntity")
    public abstract MessageEntity dtoToEntity(final MessageDTO messageDTO);

    /**
     *
     * @param messageDTOList
     * @return
     */
    @IterableMapping(qualifiedByName = "dtoToEntity")
    public abstract List<MessageEntity> dtoToEntity(List<MessageDTO> messageDTOList);
}
