package com.foursquare.adapter.rest;

import com.foursquare.adapter.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/places")
public class RecommendedPlacesController {

    @Value("${spring.application.name}")
    private String name;

    @Autowired
    @Qualifier("PropertyService")
    PropertyService propertyService;

    @RequestMapping(method = RequestMethod.GET, produces = { "application/json" }, path = "/{place}")
    public String getRecommendedPlaces(@PathVariable("place") String place) {
        System.out.println("place --> " + propertyService.getClientSecret());
        return place;
    }
}
