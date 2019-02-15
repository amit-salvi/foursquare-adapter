package com.foursquare.adapter.model;

public class SuggestedFilter {

    private String header;
    private Filter[] filters;

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public Filter[] getFilters() {
        return filters;
    }

    public void setFilters(Filter[] filters) {
        this.filters = filters;
    }
}
