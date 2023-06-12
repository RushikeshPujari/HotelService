package com.RP.hotel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.RP.hotel.entities.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, String> {

}
