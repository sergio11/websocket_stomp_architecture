package com.dreamsoftware.websocketclient.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 *
 * @author ssanchez
 */
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = MessageEntity.COLLECTION_NAME)
public class MessageEntity {

    public final static String COLLECTION_NAME = "messages";

    /**
     * Id
     */
    @Id
    private ObjectId id;

    /**
     * User name
     */
    @Field("username")
    private String username;

    /**
     * Latitude
     */
    @Field("latitude")
    private Double latitude;

    /**
     * Longitude
     */
    @Field("longitude")
    private Double longitude;

    /**
     * Speed
     */
    @Field("speed")
    private Double speed;

    /**
     * Battery Level
     */
    @Field("battery_level")
    private Integer batteryLevel;

}
