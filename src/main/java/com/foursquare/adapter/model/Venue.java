package com.foursquare.adapter.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Arrays;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Venue {

    @JsonIgnore
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Venue venue = (Venue) o;
        return Objects.equals(id, venue.id) &&
                Objects.equals(name, venue.name) &&
                Objects.equals(location, venue.location) &&
                Arrays.equals(categories, venue.categories) &&
                Objects.equals(photos, venue.photos);
    }

    @Override
    public int hashCode() {

        int result = Objects.hash(id, name, location, photos);
        result = 31 * result + Arrays.hashCode(categories);
        return result;
    }

    @Override
    public String toString() {
        return "Venue{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", location=" + location +
                ", categories=" + Arrays.toString(categories) +
                ", photos=" + photos +
                '}';
    }
}
