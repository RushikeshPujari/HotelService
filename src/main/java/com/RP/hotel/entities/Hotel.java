package com.RP.hotel.entities;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.misc.NotNull;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "hotels")
public class Hotel {
	
	@Id
	private String id;
	private String name;
	private String location;
	private String about;
	
	@Transient  // --> This we dont want to store in database.
	private List<Rating> ratings = new ArrayList<Rating>();

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> rating) {
		this.ratings = rating;
	}
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public Hotel(String id, String name, String location, String about) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.about = about;
	}
	public Hotel() {
		super();
		// TODO Auto-generated constructor stub
	}
 
	
}
