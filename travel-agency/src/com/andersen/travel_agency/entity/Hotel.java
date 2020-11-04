package com.andersen.travel_agency.entity;

import java.util.Objects;

public class Hotel {

    private long id;
    private String stars;
    private int coast;

    public Hotel(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStars() {
        return stars;
    }

    public void setStars(String stars) {
        this.stars = stars;
    }

    public int getCoast() {
        return coast;
    }

    public void setCoast(int coast) {
        this.coast = coast;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hotel hotel = (Hotel) o;
        return id == hotel.id &&
                coast == hotel.coast &&
                Objects.equals(stars, hotel.stars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, stars, coast);
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", stars='" + stars + '\'' +
                ", coast=" + coast +
                '}';
    }
}
