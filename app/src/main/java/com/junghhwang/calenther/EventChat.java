package com.junghhwang.calenther;

import java.util.List;

/**
 * Created by solmoms on 11/28/2016.
 */

public class EventChat {
    private String name;
    private String time;
    private String index;
    private List<String> userUIDs;

    public EventChat() {
    }

    public EventChat(String name, String time, String index, List<String> userUIDs) {
        this.name = name;
        this.time = time;
        this.index = index;
        this.userUIDs = userUIDs;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof EventChat)) {
            return false;
        }
        EventChat other = (EventChat) obj;
        return this.name.equals(other.name) && this.index.equals(other.index);
    }

    public String getName() {
        return name;
    }

    public String getTime() {
        return time;
    }

    public String getIndex() {
        return index;
    }

    public List<String> getUserUIDs() {
        return userUIDs;
    }
}
