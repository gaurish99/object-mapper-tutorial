package com.mapper.object.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class EventBatches {

    @JsonProperty("eventbatch")
    private List<EventBatch> eventbatch;

    public List<EventBatch> getListOfEventBatch() {
        return eventbatch;
    }

    public void setListOfEventBatch(List<EventBatch> eventbatch) {
        this.eventbatch = eventbatch;
    }

    @Override
    public String toString() {
        return "EventBatches{" +
            "eventbatch=" + eventbatch +
            '}';
    }
}
