package com.foursquare.adapter.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import springfox.documentation.annotations.Cacheable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RecommendedPlace {

    private Meta meta;
    private FoursquareResponse response;

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public FoursquareResponse getResponse() {
        return response;
    }

    public void setResponse(FoursquareResponse response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return "RecommendedPlace{" +
                "meta=" + meta +
                ", response=" + response +
                '}';
    }
}
