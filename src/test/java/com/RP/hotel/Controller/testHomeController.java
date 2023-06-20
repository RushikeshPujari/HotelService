package com.RP.hotel.Controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;

import com.RP.hotel.controller.HomeController;
import com.RP.hotel.entities.Hotel;
import com.RP.hotel.repositories.HotelRepository;
import com.RP.hotel.services.HotelServices;

public class testHomeController{

	
	
	HomeController homeController = new HomeController();
	
	HotelServices hotelServices = Mockito.mock(HotelServices.class);
	
	List<Hotel> myHotelList;
	
	public List<Hotel> createMockHotelData(){
		List<Hotel> hotelList = new ArrayList<Hotel>();
		Hotel hotel = new Hotel();
		hotel.setId("1");
		hotel.setAbout("about");
		hotel.setLocation("Location");
		hotel.setName("name");
		hotelList.add(hotel);
		return hotelList;
	}
	
	@Test
	void test_GetAllHotels() {
		ReflectionTestUtils.setField(homeController, "hotelServices", hotelServices);
		List<Hotel> myHotelList = createMockHotelData();
		
		when(hotelServices.getAll()).thenReturn(myHotelList);
		
		ResponseEntity<List<Hotel>> response = homeController.getAllHotel();
		
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(myHotelList, response.getBody());
		
	}
	
	@Test
	void test_GetSingleHotel() {
		
		ReflectionTestUtils.setField(homeController, "hotelServices", hotelServices);
		List<Hotel> myHotelList = createMockHotelData();
		
		String id = myHotelList.get(0).getId();
		
		when(hotelServices.get(id)).thenReturn(myHotelList.get(0));
		
		ResponseEntity<Hotel> response = homeController.getsingleHotel(id);
		
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(myHotelList.get(0), response.getBody());

	}
	
	@Test
	void test_PostCreateHotel() {
		
		ReflectionTestUtils.setField(homeController, "hotelServices", hotelServices);
		
		Hotel input_Hotel = new Hotel("101","about","Location","name");
		
		Hotel Created_hotel= new Hotel("101","about","Location","name");
		when(hotelServices.create(input_Hotel)).thenReturn(Created_hotel);
		
		ResponseEntity<Hotel> response = homeController.createHotel(input_Hotel);
		
		assertEquals(HttpStatus.CREATED, response.getStatusCode());
		assertEquals(Created_hotel, response.getBody());
		
	}
}
