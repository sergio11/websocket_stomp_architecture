package com.dreamsoftware.websocketserver.web.controller.error;

/**
 *
 * @author ssanchez
 */
public class PublishMessageException extends RuntimeException {

    public PublishMessageException(String message, Throwable cause) {
        super(message, cause);
    }
}
