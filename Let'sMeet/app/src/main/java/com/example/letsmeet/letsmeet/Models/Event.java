package com.example.letsmeet.letsmeet.Models;

import java.io.Serializable;

/**
 * Created by Soot_Win on 2015-03-21.
 */
public class Event {

    private int type;
    private int mode;
    private String name;
    private String description;
    private int participantsMax;
    private int participantsCurrent;
    private String place;
    private String date;

    public Event() {
    }

    public Event(int type, int mode, String name, String description, int participantsMax, int participantsCurrent, String place, String date) {
        this.type = type;
        this.mode = mode;
        this.name = name;
        this.description = description;
        this.participantsMax = participantsMax;
        this.participantsCurrent = participantsCurrent;
        this.place = place;
        this.date = date;
    }

    // ---------- get / set methods ----------
    public int getType() {
        return type;
    }
    public void setType(int type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public int getMode() {
        return mode;
    }
    public void setMode(int mode) {
        this.mode = mode;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getParticipantsMax() {
        return participantsMax;
    }
    public void setParticipantsMax(int participantsMax) {
        this.participantsMax = participantsMax;
    }

    public int getParticipantsCurrent() {
        return participantsCurrent;
    }
    public void setParticipantsCurrent(int participantsCurrent) {
        this.participantsCurrent = participantsCurrent;
    }

    public String getPlace() {
        return place;
    }
    public void setPlace(String place) {
        this.place = place;
    }

    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    // ---------- ----------
}
