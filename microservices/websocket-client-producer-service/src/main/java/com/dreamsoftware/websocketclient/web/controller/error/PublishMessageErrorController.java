package com.dreamsoftware.websocketclient.web.controller.error;

import com.dreamsoftware.websocketclient.web.controller.PublishMessageResponseCodeEnum;
import com.dreamsoftware.websocketclient.web.controller.PublishMessageResponseCodeEnum;
import com.dreamsoftware.websocketclient.web.core.SupportController;
import javax.servlet.http.HttpServletRequest;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import com.dreamsoftware.websocketclient.web.core.APIResponse;
import com.dreamsoftware.websocketclient.web.core.ErrorResponseDTO;

/**
 *
 * @author ssanchez
 */
@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class PublishMessageErrorController extends SupportController {

    /**
     *
     * @param ex
     * @param request
     * @return
     */
    @ExceptionHandler(PublishMessageException.class)
    @ResponseBody
    protected ResponseEntity<APIResponse<ErrorResponseDTO>> handlePublishMessageException(PublishMessageException ex, HttpServletRequest request) {
        return responseHelper.<String>createAndSendErrorResponse(PublishMessageResponseCodeEnum.MESSAGE_NOT_PUBLISHED,
                HttpStatus.INTERNAL_SERVER_ERROR, "Message can not be pusblished");
    }
}
