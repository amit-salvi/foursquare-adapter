package com.foursquare.adapter.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FoursquareResponse {

    private SuggestedFilter suggestedFilters;
    private Geocode geocode;
    private String headerLocation;
    private String headerFullLocation;
    private String headerLocationGranularity;
    private Integer totalResults;
    private Group[] groups;
    private SuggestedBound suggestedBounds;

    public Group[] getGroups() {
        return groups;
    }

    public void setGroups(Group[] groups) {
        this.groups = groups;
    }

    public SuggestedBound getSuggestedBounds() {
        return suggestedBounds;
    }

    public void setSuggestedBounds(SuggestedBound suggestedBounds) {
        this.suggestedBounds = suggestedBounds;
    }

    public SuggestedFilter getSuggestedFilters() {
        return suggestedFilters;
    }

    public void setSuggestedFilters(SuggestedFilter suggestedFilters) {
        this.suggestedFilters = suggestedFilters;
    }

    public Geocode getGeocode() {
        return geocode;
    }

    public void setGeocode(Geocode geocode) {
        this.geocode = geocode;
    }

    public String getHeaderLocation() {
        return headerLocation;
    }

    public void setHeaderLocation(String headerLocation) {
        this.headerLocation = headerLocation;
    }

    public String getHeaderFullLocation() {
        return headerFullLocation;
    }

    public void setHeaderFullLocation(String headerFullLocation) {
        this.headerFullLocation = headerFullLocation;
    }

    public String getHeaderLocationGranularity() {
        return headerLocationGranularity;
    }

    public void setHeaderLocationGranularity(String headerLocationGranularity) {
        this.headerLocationGranularity = headerLocationGranularity;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    @Override
    public String toString() {
        return "FoursquareResponse{" +
                "suggestedFilter=" + suggestedFilters +
                ", geocode='" + geocode + '\'' +
                ", headerLocation='" + headerLocation + '\'' +
                ", headerFullLocation='" + headerFullLocation + '\'' +
                ", headerLocationGranularity='" + headerLocationGranularity + '\'' +
                ", totalResults=" + totalResults +
                ", groups=" + groups +
                ", suggestedBounds=" + suggestedBounds +
                '}';
    }
}
