package com.foursquare.adapter.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Location {

    private String address;
    private String crossStreet;
    private Double lat;
    private Double lng;
    private LabeledLatLng[] labeledLatLngs;
    private String postalCode;
    private String cc;
    private String city;
    private String state;
    private String country;
    private String[] formattedAddress;
    private String neighborhood;

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCrossStreet() {
        return crossStreet;
    }

    public void setCrossStreet(String crossStreet) {
        this.crossStreet = crossStreet;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public LabeledLatLng[] getLabeledLatLngs() {
        return labeledLatLngs;
    }

    public void setLabeledLatLngs(LabeledLatLng[] labeledLatLngs) {
        this.labeledLatLngs = labeledLatLngs;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String[] getFormattedAddress() {
        return formattedAddress;
    }

    public void setFormattedAddress(String[] formattedAddress) {
        this.formattedAddress = formattedAddress;
    }
}
