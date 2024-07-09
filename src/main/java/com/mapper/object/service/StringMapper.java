package com.mapper.object.service;

import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class StringMapper {

    public String getData() throws IOException {
        File inputFileMessage = ResourceUtils.getFile("C:/Users/Gaurish_Dwivedi/Downloads/Assignment java8/eventBatchInputMultipleJSON.txt");
        String jsonString = new String(Files.readAllBytes(inputFileMessage.toPath()));


        jsonString = StringUtility.addToStartAndEnd(jsonString, "{\"eventbatches\":[", "]}");
//        jsonString = StringUtility.addAfterSequence(jsonString, "\n", ",");

        return jsonString;
    }


}
