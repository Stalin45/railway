package com.tschool.railwayapp.commons.commands;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommandResponse <T extends Serializable> implements Serializable {
    private int resultCode;
    private HashMap<ContentKey, Object> content = new HashMap<ContentKey, Object>();
    private Exception exception;

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public Map<ContentKey, ?> getContent() {
        return content;
    }

    public void putContent(ContentKey key, Object entity) {
        content.put(key, entity);
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }
}
