package com.dreamsoftware.websocketserver.web.controller;

import com.dreamsoftware.websocketserver.service.IPublishMessageService;
import com.dreamsoftware.websocketserver.web.core.SupportController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import com.dreamsoftware.websocketserver.web.core.APIResponse;
import com.dreamsoftware.websocketserver.web.controller.error.PublishMessageException;
import com.dreamsoftware.websocketserver.web.dto.PublishMessageDTO;

/**
 *
 * @author ssanchez
 */
@RestController
@Validated
@RequestMapping("/api/v1/messages/")
@Tag(name = "messages", description = "/api/v1/messages/ (Code Response interval -> 1XX)")
@RequiredArgsConstructor
public class PublishMessageController extends SupportController {

    private static final Logger logger = LoggerFactory.getLogger(PublishMessageController.class);

    /**
     * Publish Message Service
     */
    private final IPublishMessageService publishMessageService;

    /**
     * Publish Message
     *
     * @param messageDTO
     * @return
     * @throws Throwable
     */
    @Operation(summary = "PUBLISH_MESSAGE", description = "Publish Message")
    @RequestMapping(value = "/", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<APIResponse<String>> publishMessage(
            @Parameter(name = "message", description = "Message Data.",
                    required = true, schema = @Schema(implementation = PublishMessageDTO.class)) PublishMessageDTO messageDTO) throws Throwable {

        try {

            logger.debug("Publish Message -> " + messageDTO.getUsername());

            publishMessageService.publish(messageDTO);

            return responseHelper.createAndSendResponse(
                    PublishMessageResponseCodeEnum.MESSAGE_PUBLISHED, HttpStatus.OK,
                    "Message Published");

        } catch (final Exception ex) {
            logger.debug("Publish Message fail -> " + ex.getMessage());
            throw new PublishMessageException(ex.getMessage(), ex);
        }
    }

}
