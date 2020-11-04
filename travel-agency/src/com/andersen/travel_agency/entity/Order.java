package com.andersen.travel_agency.entity;

import java.util.Objects;

public class Order {

    private int id;
    private User user;
    private Tour tour;

    public Order(){

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id &&
                Objects.equals(user, order.user) &&
                Objects.equals(tour, order.tour);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, tour);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", user=" + user +
                ", tour=" + tour +
                '}';
    }
}
