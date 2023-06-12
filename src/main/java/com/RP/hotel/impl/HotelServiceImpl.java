package com.RP.hotel.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RP.hotel.entities.Hotel;
import com.RP.hotel.exceptions.ResourceNotFound;
import com.RP.hotel.repositories.HotelRepository;
import com.RP.hotel.services.HotelServices;


@Service
public class HotelServiceImpl implements HotelServices{
	
	@Autowired
	private HotelRepository hotelRepository;

	@Override
	public Hotel create(Hotel hotel) {
		// TODO Auto-generated method stub
		String generatedId = UUID.randomUUID().toString();
		hotel.setId(generatedId);
		return hotelRepository.save(hotel);
	}

	@Override
	public List<Hotel> getAll() {
		// TODO Auto-generated method stub
		return hotelRepository.findAll();
	}

	@Override
	public Hotel get(String id) {
		// TODO Auto-generated method stub
		return hotelRepository.findById(id).orElseThrow(()-> new ResourceNotFound("User with Given ID is not Found in server --> ID : "+id));

	}

}
