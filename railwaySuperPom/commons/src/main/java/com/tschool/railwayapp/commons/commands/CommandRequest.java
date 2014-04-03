package com.tschool.railwayapp.commons.commands;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class CommandRequest implements Serializable {
    private Command command;
    private HashMap<ContentKey, Object> content = new HashMap<ContentKey, Object>();

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public Map<ContentKey, ?> getContent() {
        return content;
    }

    public void putContent(ContentKey key, Object entity) {
        content.put(key, entity);
    }
}