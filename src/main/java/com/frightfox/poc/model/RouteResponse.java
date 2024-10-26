package com.frightfox.poc.model;

import com.frightfox.poc.entity.Route;

public class RouteResponse {
    private String fromPincode;
    private String toPincode;
    private int distance;
    private String duration;
    private String route;

    // Constructors, getters and setters
    

    public RouteResponse(String fromPincode, String toPincode, int distance, String duration, String route) {
        this.fromPincode = fromPincode;
        this.toPincode = toPincode;
        this.distance = distance;
        this.duration = duration;
        this.route = route;
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

	public RouteResponse(Route route) {
        this.fromPincode = route.getFromPincode();
        this.toPincode = route.getToPincode();
        this.distance = route.getDistance();
        this.duration = route.getDuration();
        this.route = route.getRoute();
    }
}
