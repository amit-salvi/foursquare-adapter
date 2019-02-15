package com.foursquare.adapter.model;

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
