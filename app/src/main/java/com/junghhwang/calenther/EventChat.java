package com.junghhwang.calenther;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by solmoms on 11/28/2016.
 */

public class EventChat implements Parcelable {
    private String name;
    private int year;
    private int month;
    private int dayOfMonth;
    private int startHour;
    private int startMinute;
    private String key;
    private List<String> userUIDs;
    private String masterUID;

    public String getMasterUID() {
        return masterUID;
    }

    public void setMasterUID(String masterUID) {
        this.masterUID = masterUID;
    }

    public static final String EVENT_CHAT_KEY = "this_is_event_chat";

    public EventChat() {
        userUIDs = new ArrayList<>();
    }

    public EventChat(String name, int month, int year, int dayOfMonth, int startHour, int startMinute, String key, List<String> userUIDs, String masterUID) {
        this.name = name;
        this.month = month;
        this.year = year;
        this.dayOfMonth = dayOfMonth;
        this.startHour = startHour;
        this.startMinute = startMinute;
        this.key = key;
        this.userUIDs = userUIDs;
        this.masterUID = masterUID;
    }

    public int getStartHour() {
        return startHour;
    }

    public void setStartHour(int startHour) {
        this.startHour = startHour;
    }

    public int getStartMinute() {
        return startMinute;
    }

    public void setStartMinute(int startMinute) {
        this.startMinute = startMinute;
    }

    protected EventChat(Parcel in) {
        name = in.readString();
        year = in.readInt();
        month = in.readInt();
        dayOfMonth = in.readInt();
        startHour = in.readInt();
        startMinute = in.readInt();
        key = in.readString();
        userUIDs = in.createStringArrayList();
    }

    public static final Creator<EventChat> CREATOR = new Creator<EventChat>() {
        @Override
        public EventChat createFromParcel(Parcel in) {
            return new EventChat(in);
        }

        @Override
        public EventChat[] newArray(int size) {
            return new EventChat[size];
        }
    };

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof EventChat)) {
            return false;
        }
        EventChat other = (EventChat) obj;
        return this.name.equals(other.name) && this.key.equals(other.key);
    }

    public String getName() {
        return name;
    }

    public String getKey() {
        return key;
    }

    public List<String> getUserUIDs() {
        return userUIDs;
    }

    public int getYear() {
        return year;
    }

    public int getDayOfMonth() {
        return dayOfMonth;
    }

    public int getMonth() {
        return month;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeString(this.key);
        parcel.writeInt(this.year);
        parcel.writeInt(this.month);
        parcel.writeInt(this.dayOfMonth);
        parcel.writeDouble(startHour);
        parcel.writeStringList(userUIDs);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setDayOfMonth(int dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setUserUIDs(List<String> userUIDs) {
        this.userUIDs = userUIDs;
    }
}
