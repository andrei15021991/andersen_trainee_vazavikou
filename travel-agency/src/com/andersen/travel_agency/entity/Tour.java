package com.andersen.travel_agency.entity;

import java.util.Objects;

public class Tour {

    private long id;
    private Country country;
    private Hotel hotel;
    private Review review;
    private int totalCoast;

    public Tour(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public int getTotalCoast() {
        return totalCoast;
    }

    public void setTotalCoast(int totalCoast) {
        this.totalCoast = totalCoast;
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }

    public void showInfo(){
        System.out.println("[" + id + "]" + " [country - " + country.getName() + "]" + " [hotel - " + hotel.getStars() + "]" + " [coast - " + totalCoast + "]");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tour tour = (Tour) o;
        return id == tour.id &&
                totalCoast == tour.totalCoast &&
                Objects.equals(country, tour.country) &&
                Objects.equals(hotel, tour.hotel) &&
                Objects.equals(review, tour.review);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, country, hotel, review, totalCoast);
    }

    @Override
    public String toString() {
        return "Tour{" +
                "id=" + id +
                ", country=" + country +
                ", hotel=" + hotel +
                ", review=" + review +
                ", totalCoast=" + totalCoast +
                '}';
    }
}
