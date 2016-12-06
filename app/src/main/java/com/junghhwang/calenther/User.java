package com.junghhwang.calenther;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by junghhwang on 11/29/16.
 */

public class User {
    private String UID;
    private String email;
    private String username;
    private List<String> events;

    public List<String> getEvents() {
        return events;
    }

    public void setEvents(List<String> events) {
        this.events = events;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUID() {
        return UID;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public User(String UID, String email, String username, List<String> events) {

        this.UID = UID;
        this.email = email;
        this.username = username;
        this.events = events;
    }

    public User() {
        events = new ArrayList<>();
    }
}
