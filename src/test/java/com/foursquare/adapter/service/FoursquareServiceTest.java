package com.foursquare.adapter.service;

import com.foursquare.adapter.model.Group;
import com.foursquare.adapter.model.RecommendedPlace;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FoursquareServiceTest {

    @Test
    public void readJson() throws URISyntaxException, IOException {
        Stream<String> lines = Files.lines(Paths.get("src/test/resources/sample.json"));
        String data = lines.collect(Collectors.joining("\n"));
        Assertions.assertNotNull(data);
        lines.close();
    }

    @Test
    public void unmarshalJsonToObject() throws Exception {
        Stream<String> lines = Files.lines(Paths.get("src/test/resources/sample.json"));
        String data = lines.collect(Collectors.joining("\n"));
        Assertions.assertNotNull(data);
        lines.close();

        Gson gson = new Gson();
        RecommendedPlace recommendedPlace = gson.fromJson(data, RecommendedPlace.class);
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
}
