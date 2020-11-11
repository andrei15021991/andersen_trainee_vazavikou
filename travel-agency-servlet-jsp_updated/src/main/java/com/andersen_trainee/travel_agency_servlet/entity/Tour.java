package com.andersen_trainee.travel_agency_servlet.entity;

public class Tour {
	private int id;
	private Country country;
	private Hotel hotel;
	private Review review;
	private int totalCoast;

	public Tour() {

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

	public Review getReview() {
		return review;
	}

	public void setReview(Review review) {
		this.review = review;
	}

	public int getTotalCoast() {
		return totalCoast;
	}

	public void setTotalCoast(int totalCoast) {
		this.totalCoast = totalCoast;
	}

	public void showInfo() {
		System.out.println("[" + id + "]" + " [country - " + country.getName() + "]" + " [hotel - " + hotel.getStars()
				+ "]" + " [coast - " + totalCoast + "]");
	}

}
