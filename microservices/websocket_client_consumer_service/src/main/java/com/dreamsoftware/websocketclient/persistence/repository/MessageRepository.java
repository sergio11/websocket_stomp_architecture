package com.dreamsoftware.websocketclient.persistence.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.dreamsoftware.websocketclient.persistence.entity.MessageEntity;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ssanchez
 */
@Repository
public interface MessageRepository extends MongoRepository<MessageEntity, ObjectId> {

}
