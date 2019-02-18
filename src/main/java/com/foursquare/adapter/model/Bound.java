package com.foursquare.adapter.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Bound {

    private SuggestedBoundLatLng ne;
    private SuggestedBoundLatLng sw;

    public SuggestedBoundLatLng getNe() {
        return ne;
    }

    public void setNe(SuggestedBoundLatLng ne) {
        this.ne = ne;
    }

    public SuggestedBoundLatLng getSw() {
        return sw;
    }

    public void setSw(SuggestedBoundLatLng sw) {
        this.sw = sw;
    }
}
