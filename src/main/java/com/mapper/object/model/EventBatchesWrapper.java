package com.mapper.object.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class EventBatchesWrapper {

    @JsonProperty("eventbatches")
    private List<EventBatches> eventbatches;

    public List<EventBatches> getEventbatches() {
        return eventbatches;
    }

    public void setEventbatches(List<EventBatches> eventbatches) {
        this.eventbatches = eventbatches;
    }

    @Override
    public String toString() {
        return "EventBatchesWrapper{" +
            "eventbatches=" + eventbatches +
            '}';
    }
}
