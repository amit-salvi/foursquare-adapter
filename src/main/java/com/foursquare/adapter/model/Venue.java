package com.foursquare.adapter.model;

public class Venue {

    private String id;
    private String name;
    private Location location;
    private Category[] categories;
    private Photo photos;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Category[] getCategories() {
        return categories;
    }

    public void setCategories(Category[] categories) {
        this.categories = categories;
    }

    public Photo getPhotos() {
        return photos;
    }

    public void setPhotos(Photo photos) {
        this.photos = photos;
    }
}
