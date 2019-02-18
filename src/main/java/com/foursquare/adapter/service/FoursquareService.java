package com.foursquare.adapter.service;

import com.foursquare.adapter.constants.FoursquareAdapterConstants;
import com.foursquare.adapter.exception.FoursquareException;
import com.foursquare.adapter.model.RecommendedPlace;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public interface FoursquareService {

    final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

    final ZonedDateTime now8 = ZonedDateTime.now();

    public RecommendedPlace getRecommendedPlaces(String place, String category) throws FoursquareException;

    static String formUrl(String place, String clientId, String clientSecret, String category) {
        return new StringBuilder()
                .append(FoursquareAdapterConstants.RECOMMENDED_PLACE_API)
                .append("?near=")
                .append(place)
                .append("&client_id=")
                .append(clientId)
                .append("&client_secret=")
                .append(clientSecret)
                .append("&v=")
                .append(formatter.format(now8))
                .append(category != null ? "&section="+category : "")
                .toString();

    }
}
