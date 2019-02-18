package com.foursquare.adapter.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Item {

    private Reason reasons;
    private Venue venue;
    private String referralId;

    public Reason getReasons() {
        return reasons;
    }

    public void setReasons(Reason reasons) {
        this.reasons = reasons;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public String getReferralId() {
        return referralId;
    }

    public void setReferralId(String referralId) {
        this.referralId = referralId;
    }
}
