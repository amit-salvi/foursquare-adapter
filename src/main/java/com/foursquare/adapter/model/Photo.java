package com.foursquare.adapter.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Photo {

    private Integer count;
    private Object[] groups;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Object[] getGroups() {
        return groups;
    }

    public void setGroups(Object[] groups) {
        this.groups = groups;
    }
}
