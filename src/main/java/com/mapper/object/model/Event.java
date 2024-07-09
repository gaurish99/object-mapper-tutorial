package com.mapper.object.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Event {

    @JsonProperty("attributes")
    private List<Attribute> attributes;

    @JsonProperty("code")
    private String code;

    @JsonProperty("timestamp")
    private String timestamp;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    @Override
    public String toString() {
        return "Event{" +
            "attributes=" + attributes +
            ", code='" + code + '\'' +
            ", timestamp='" + timestamp + '\'' +
            '}';
    }
}
