package com.mapper.object.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


public class EventBatch {

    @JsonProperty("channel")
    private String channel;

    @JsonProperty("identifiers")
    private List<String> identifiers;

    @JsonProperty("events")
    private List<Event> events;

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public List<String> getIdentifiers() {
        return identifiers;
    }

    public void setIdentifiers(List<String> identifiers) {
        this.identifiers = identifiers;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    @Override
    public String toString() {
        return "EventBatch{" +
            "channel='" + channel + '\'' +
            ", identifiers=" + identifiers +
            ", events=" + events +
            '}';
    }
}
