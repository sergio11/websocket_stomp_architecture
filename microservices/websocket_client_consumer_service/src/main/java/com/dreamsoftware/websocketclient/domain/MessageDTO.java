package com.dreamsoftware.websocketclient.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 *
 * @author ssanchez
 */
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class MessageDTO implements Serializable {

    /**
     * User Name
     */
    @JsonProperty("username")
    private String username;

    /**
     * Latitude
     */
    @JsonProperty("latitude")
    private Double latitude;

    /**
     * Longitude
     */
    @JsonProperty("longitude")
    private Double longitude;

    /**
     * Speed
     */
    @JsonProperty("speed")
    private Double speed;

    /**
     * Battery Level
     */
    @JsonProperty("battery_level")
    private Integer batteryLevel;
}
