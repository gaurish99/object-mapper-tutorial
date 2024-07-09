package com.mapper.object.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mapper.object.model.EventBatchesWrapper;

import java.io.IOException;

public class Mapper {

    public EventBatchesWrapper mapData() throws IOException {

        StringMapper sm = new StringMapper();
        String jsonString = sm.getData();

        ObjectMapper objectMapper = new ObjectMapper();

        EventBatchesWrapper eventBatchWrapper = objectMapper.readValue(jsonString, EventBatchesWrapper.class);

        return eventBatchWrapper;

    }
}
