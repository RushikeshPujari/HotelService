package com.RP.hotel.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;

import com.RP.hotel.entities.Hotel;
import com.RP.hotel.exceptions.ResourceNotFound;
import com.RP.hotel.repositories.HotelRepository;

class testHotelServicesImpl {
	
	HotelServiceImpl hotelServiceImpl = new HotelServiceImpl();
	
	
	HotelRepository hotelRepository = Mockito.mock(HotelRepository.class);
	
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
	void test_getAll() {
		
		ReflectionTestUtils.setField(hotelServiceImpl, "hotelRepository", hotelRepository);
		List<Hotel> hotelList = createMockHotelData();
		when(hotelRepository.findAll()).thenReturn(hotelList);
		
		List<Hotel> response = hotelServiceImpl.getAll();
		
		assertEquals(1, response.size());
		
	}
	@Test
	void test_create() {
		
		ReflectionTestUtils.setField(hotelServiceImpl, "hotelRepository", hotelRepository);
		
		List<Hotel> hotelList = createMockHotelData();
		when(hotelRepository.save(Mockito.any(Hotel.class))).thenReturn(hotelList.get(0));
		
		Hotel response =hotelServiceImpl.create(hotelList.get(0));
		
		assertEquals("about", response.getAbout());
		
	}
	
	//Passing scenario
	@Test
	void test_get_pass() {
		ReflectionTestUtils.setField(hotelServiceImpl, "hotelRepository", hotelRepository);
		
		List<Hotel> hotelList = createMockHotelData();
		when(hotelRepository.findById(hotelList.get(0).getId())).thenReturn(Optional.of(hotelList.get(0)));
		
		Hotel response =hotelServiceImpl.get("1");
		
		assertEquals("name", response.getName());
		
		
	}
	
		//Failing scenario
		@Test
		void test_get_fail() {
			ReflectionTestUtils.setField(hotelServiceImpl, "hotelRepository", hotelRepository);

			ResourceNotFound thrown = Assertions.assertThrows(ResourceNotFound.class, () -> hotelServiceImpl.get("2"));
			assertEquals("User with Given ID is not Found in server --> ID : " + 2, thrown.getMessage());
			
		}
}
