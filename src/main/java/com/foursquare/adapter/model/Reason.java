package com.foursquare.adapter.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Reason {

    private Integer count;
    private ReasonItem[] items;

    public ReasonItem[] getItems() {
        return items;
    }

    public void setItems(ReasonItem[] items) {
        this.items = items;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
