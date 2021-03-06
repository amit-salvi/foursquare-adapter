package com.foursquare.adapter.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SuggestedBound {
    private LabeledLatLng ne;
    private LabeledLatLng sw;

    public LabeledLatLng getNe() {
        return ne;
    }

    public void setNe(LabeledLatLng ne) {
        this.ne = ne;
    }

    public LabeledLatLng getSw() {
        return sw;
    }

    public void setSw(LabeledLatLng sw) {
        this.sw = sw;
    }
}
