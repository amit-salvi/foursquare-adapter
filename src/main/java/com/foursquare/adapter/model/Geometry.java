package com.foursquare.adapter.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Geometry {

    private Bound bounds;

    public Bound getBounds() {
        return bounds;
    }

    public void setBounds(Bound bounds) {
        this.bounds = bounds;
    }
}
