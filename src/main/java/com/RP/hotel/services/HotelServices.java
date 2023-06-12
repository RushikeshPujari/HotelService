package com.RP.hotel.services;

import java.util.List;

import com.RP.hotel.entities.Hotel;

public interface HotelServices {
	
	//create
	Hotel create(Hotel hotel);
	//getAll
	List<Hotel> getAll();
	//get single
	
	Hotel get(String id);
}
