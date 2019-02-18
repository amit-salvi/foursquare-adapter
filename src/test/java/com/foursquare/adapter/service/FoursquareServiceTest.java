package com.foursquare.adapter.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.foursquare.adapter.model.*;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FoursquareServiceTest {

    @Test
    public void readJson() throws URISyntaxException, IOException {
        String data = getData("src/test/resources/sample.json");
        Assertions.assertNotNull(data);
    }

    @Test
    public void unmarshalJsonToObject() throws Exception {
        String data = getData("src/test/resources/sample.json");
        Assertions.assertNotNull(data);

        ObjectMapper objectMapper = new ObjectMapper();
        RecommendedPlace recommendedPlace = objectMapper.readValue(data, RecommendedPlace.class);
        Assertions.assertNotNull(recommendedPlace);
        Assertions.assertEquals(recommendedPlace.getMeta().getCode(), 200);

        // check response object
        Assertions.assertNotNull(recommendedPlace.getResponse());
        Assertions.assertEquals(recommendedPlace.getResponse().getHeaderLocation(), "New York");
        Assertions.assertNotNull(recommendedPlace.getResponse().getGeocode());
        Assertions.assertNotNull(recommendedPlace.getResponse().getGeocode().getGeometry());
        Assertions.assertNotNull(recommendedPlace.getResponse().getGeocode().getGeometry().getBounds());
        Assertions.assertNotNull(recommendedPlace.getResponse().getSuggestedFilters().getFilters());
        Assertions.assertNotNull(recommendedPlace.getResponse().getSuggestedBounds());
        Assertions.assertNotNull(recommendedPlace.getResponse().getGroups());
        Assertions.assertEquals(recommendedPlace.getResponse().getGroups().length, 1);

        for (Group group : recommendedPlace.getResponse().getGroups()) {
            Assertions.assertNotNull(group.getItems());
            Assertions.assertEquals(group.getItems().length, 30);
            Assertions.assertNotNull(group.getName());
            Assertions.assertNotNull(group.getType());
        }
    }

    @Test
    public void testStreamOfVenues() throws Exception {
        String data = getData("src/test/resources/sample.json");
        Assertions.assertNotNull(data);

        ObjectMapper objectMapper = new ObjectMapper();
        RecommendedPlace recommendedPlace = objectMapper.readValue(data, RecommendedPlace.class);
        Assertions.assertNotNull(recommendedPlace.getResponse());

        Group[] groups = recommendedPlace.getResponse().getGroups();
        List<Venue> venues = new ArrayList<>();
        for(Group group : groups) {
            for (Item item : group.getItems()) venues.add(item.getVenue());
        }
        Assertions.assertNotNull(venues);
        Venue[] venues1 = venues.stream().toArray(size -> new Venue[size]);
        Response response = new Response();
        response.setVenues(venues1);

        String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(response);
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        Assertions.assertNotNull(json);
    }

    @Test
    public void verifyVenuesResponseObject() throws Exception {
        String data = getData("src/test/resources/venue.json");
        Assertions.assertNotNull(data);

        ObjectMapper objectMapper = new ObjectMapper();
        Response response = objectMapper.readValue(data, Response.class);

        Venue[] venues = Arrays.stream(response.getVenues()).toArray(Venue[]::new);
        Assertions.assertAll("venue",
                () -> Assertions.assertEquals("Central Park", venues[0].getName()),
                () -> Assertions.assertEquals("Brooklyn Bridge Park", venues[1].getName()));
    }

    private String getData(String s) throws IOException {
        Stream<String> lines = Files.lines(Paths.get(s));
        String data = lines.collect(Collectors.joining("\n"));
        lines.close();
        return data;
    }
}
