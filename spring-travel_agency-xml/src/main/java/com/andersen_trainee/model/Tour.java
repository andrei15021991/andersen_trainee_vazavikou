package com.andersen_trainee.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tour")
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tour_id")
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "country_id")
    private Country country;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    @ManyToMany(mappedBy = "tours", cascade = CascadeType.ALL)
    private Set<User> users = new HashSet<>();

    public Tour() {

    }

    public void showInfo(){
        System.out.println(id + " " + country.getName() + " " + hotel.getStars());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
