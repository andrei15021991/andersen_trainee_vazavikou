package com.andersen.travel_agency.entity;

import java.util.Objects;

public class Review {

    private long id;
    private String review;

    public Review(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review1 = (Review) o;
        return id == review1.id &&
                Objects.equals(review, review1.review);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, review);
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", review='" + review + '\'' +
                '}';
    }
}
