package com.dreamsoftware.websocketclient.web.controller;

import com.dreamsoftware.websocketclient.web.core.IResponseCodeTypes;

/**
 *
 * @author ssanchez
 */
public enum PublishMessageResponseCodeEnum implements IResponseCodeTypes {

    MESSAGE_PUBLISHED(100L),
    MESSAGE_NOT_PUBLISHED(101L);

    private final Long code;

    public static final String CATEGORY_NAME = "PUBLISH_SERVICE";

    private PublishMessageResponseCodeEnum(Long code) {
        this.code = code;
    }

    @Override
    public Long getResponseCode() {
        return code;
    }

    @Override
    public String getCategoryName() {
        return CATEGORY_NAME;
    }
}
