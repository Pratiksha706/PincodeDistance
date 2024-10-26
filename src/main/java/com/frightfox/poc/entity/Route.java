package com.frightfox.poc.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Route {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String fromPincode;
	private String toPincode;
	private int distance;
	private String duration;
	private String route;

	// Constructors, getters and setters

	public Route(String fromPincode, String toPincode, int distance, String duration, String route) {
		this.fromPincode = fromPincode;
		this.toPincode = toPincode;
		this.distance = distance;
		this.duration = duration;
		this.route = route;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFromPincode() {
		return fromPincode;
	}

	public void setFromPincode(String fromPincode) {
		this.fromPincode = fromPincode;
	}

	public String getToPincode() {
		return toPincode;
	}

	public void setToPincode(String toPincode) {
		this.toPincode = toPincode;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public Route() {
	}

	// Getters and Setters

}
