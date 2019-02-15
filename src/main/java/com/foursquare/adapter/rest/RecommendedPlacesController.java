package com.foursquare.adapter.rest;

import com.foursquare.adapter.model.RecommendedPlace;
import com.foursquare.adapter.service.PropertyService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping(value = "/places")
public class RecommendedPlacesController {

    @Value("${spring.application.name}")
    private String name;

    @Autowired
    @Qualifier("PropertyService")
    PropertyService propertyService;

    @RequestMapping(method = RequestMethod.GET, produces = { "application/json" }, path = "/{place}")
    public RecommendedPlace getRecommendedPlaces(@PathVariable("place") String place)
            throws Exception {
        Stream<String> lines = Files.lines(Paths.get("src/test/resources/sample.json"));
        String data = lines.collect(Collectors.joining("\n"));
        // Assertions.assertNotNull(data);
        lines.close();

        Gson gson = new Gson();
        RecommendedPlace recommendedPlace = gson.fromJson(data, RecommendedPlace.class);
        System.out.println(recommendedPlace);
        return recommendedPlace;
    }
}
