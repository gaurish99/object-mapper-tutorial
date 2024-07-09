package com.mapper.object;

import com.mapper.object.model.Attribute;
import com.mapper.object.model.Event;
import com.mapper.object.model.EventBatchesWrapper;
import com.mapper.object.service.DateUtil;
import com.mapper.object.service.Mapper;
import com.mapper.object.service.StringMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@SpringBootTest
class ObjectApplicationTests {

    StringMapper sm = new StringMapper();
    Mapper mapper = new Mapper();


    @Test
    void contextLoads() {
    }

    @Test
    void checkMapper() throws IOException {
        EventBatchesWrapper eventBatchesWrapper = mapper.mapData();

        List<Attribute> result = eventBatchesWrapper.getEventbatches().stream()
            .flatMap(eventBatches -> eventBatches.getListOfEventBatch().stream())
            .flatMap(eventBatch -> eventBatch.getEvents().stream())
            .flatMap(event -> event.getAttributes().stream())
            .filter(attribute -> "computeTs".equals(attribute.getName()))
            .collect(Collectors.toList());

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");


        List<Attribute> sortedAttributes = result.stream()
            .sorted(Comparator.comparing(attribute -> {
                try {
                    // Parse the "value" string into a Date
                    Date date = dateFormat.parse(attribute.getValue());
                    return date;
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
            }))
            .collect(Collectors.toList());

        System.out.println(sortedAttributes);


    }

    @Test
    void testBhasker() throws IOException {

        List<Event> events = mapper.mapData().getEventbatches().stream().
            flatMap(eventBatches -> eventBatches.getListOfEventBatch().stream())
            .flatMap(eventBatch -> eventBatch.getEvents().stream()).collect(Collectors.toList());


        //just printing events
        System.out.println(events);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

        List<Event> eventSorted = events.stream().sorted((event1, event2) -> {

            Date date1 = event1.getAttributes().stream()
                .filter(attribute -> "computeTs".equals(attribute.getName())).map(attribute -> {


                    try {
                        return dateFormat.parse(attribute.getValue());
                    } catch (ParseException e) {
                        throw new RuntimeException(e);
                    }

                }).findFirst().orElse(null);

            Date date2 = event2.getAttributes().stream()
                .filter(attribute -> "computeTs".equals(attribute.getName()))
                .map(attribute -> {
                    try {
                        return dateFormat.parse(attribute.getValue());
                    } catch (ParseException e) {
                        throw new RuntimeException(e);
                    }
                })
                .findFirst()
                .orElse(null);

            return date2.compareTo(date1);
        }).collect(Collectors.toList());


        //event sorted by attributes having name "computeTS" and value/date from latest to oldest
        System.out.println(eventSorted);


        //getting attributes to check that they are arranged in sorted manner
        System.out.println(eventSorted.stream().flatMap(event -> event.getAttributes().stream())
            .filter(attribute -> "computeTs".equals(attribute.getName())).collect(Collectors.toList()));


    }

    @Test
    void testBhasker2() throws IOException {

        List<Event> events = mapper.mapData().getEventbatches().stream().
            flatMap(eventBatches -> eventBatches.getListOfEventBatch().stream())
            .flatMap(eventBatch -> eventBatch.getEvents().stream()).collect(Collectors.toList());

        System.out.println(events);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");


        {

            events.sort((event1, event2) -> Objects.requireNonNull(DateUtil.parseDate((event2.getAttributes().stream()
                    .filter(attributes -> attributes.getName().equals("computeTs")).toList().get(0).getValue()), "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"))
                .compareTo(DateUtil.parseDate(event1.getAttributes().stream()
                    .filter(attributes -> attributes.getName().equals("computeTs")).toList().get(0).getValue(), "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")));
        }

        //event sorted by attributes having name "computeTS" and value/date from latest to oldest
        System.out.println(events);

    }

}
