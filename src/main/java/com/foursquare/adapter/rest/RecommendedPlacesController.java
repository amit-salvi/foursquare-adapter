package com.foursquare.adapter.rest;

import com.foursquare.adapter.exception.FoursquareException;
import com.foursquare.adapter.model.*;
import com.foursquare.adapter.service.FoursquareService;
import com.foursquare.adapter.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping(value = "/places")
public class RecommendedPlacesController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    @Qualifier("PropertyService")
    PropertyService propertyService;

    @RequestMapping(method = RequestMethod.GET, produces = { "application/json" }, path = "/{place}")
    public ResponseEntity getRecommendedPlaces(@PathVariable("place") String place, @RequestParam("category") String category)
            throws FoursquareException {

        FoursquareService service = (p, q) -> {

            RecommendedPlace recommendedPlace;
            try{
                recommendedPlace = restTemplate.getForObject(FoursquareService.formUrl(p,
                        propertyService.getClientId(), propertyService.getClientSecret(), q), RecommendedPlace.class);
            } catch (HttpClientErrorException e) {
                throw new FoursquareException(e.getStatusCode(), e.getStatusText(), e.getResponseHeaders(), e);
            } catch (HttpServerErrorException e) {
                throw new FoursquareException(e.getStatusCode(), e.getStatusText(), e.getResponseHeaders(), e);
            }
            return recommendedPlace;
        };

        return getResponseEntity(place, service, category);
    }

    private ResponseEntity getResponseEntity(String place, FoursquareService service, String category) {
        RecommendedPlace recommendedPlace;
        try {
            recommendedPlace = service.getRecommendedPlaces(place, category);
        } catch (FoursquareException e) {
            return new ResponseEntity(e.getStatusText(), e.getResponseHeaders(), e.getStatusCode());
        }
        return new ResponseEntity(formResponseTobeReturned(recommendedPlace), HttpStatus.OK);
    }

    private Response formResponseTobeReturned(RecommendedPlace recommendedPlace) {
        Group[] groups = recommendedPlace.getResponse().getGroups();
        Set<Venue> venues = new HashSet<>();
        for(Group group : groups) {
            for (Item item : group.getItems()) venues.add(item.getVenue());
        }
        Venue[] venues1 = venues.stream().toArray(size -> new Venue[size]);
        Response response = new Response();
        response.setVenues(venues1);
        return response;
    }
}
