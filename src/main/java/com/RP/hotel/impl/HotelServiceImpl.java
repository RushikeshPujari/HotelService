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
public class HotelServiceImpl implements HotelServices {

	@Autowired
	private HotelRepository hotelRepository;

	/*
	 * @Autowired private RestTemplate restTemplate;
	 */
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
		Hotel hotel = hotelRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFound("User with Given ID is not Found in server --> ID : " + id));

		//System.out.println(hotel.getId());
		/*
		 * Rating[] ratingOfUser =
		 * restTemplate.getForObject("http://localhost:8084/ratings", Rating[].class);
		 * User[] userList = restTemplate.getForObject("http://localhost:8080/users",
		 * User[].class);
		 * 
		 * List<Rating> ratings = Arrays.stream(ratingOfUser).toList(); List<User> users
		 * = Arrays.stream(userList).toList();
		 * 
		 * for (User user : users) { System.out.println(user); }
		 */
		/*
		 * List<Rating> ratingOfHotel = new ArrayList<Rating>(); //List<User>
		 * userWhoRate = new ArrayList<User>();
		 * 
		 * for(Rating rating : ratings) { if(hotel.getId().equals(rating.getHotelId()))
		 * { //for(User us : users) { //if(rating.getUserId().equals(us.getUserId())) {
		 * //userWhoRate.add(us); //} //} //rating.setUsers(userWhoRate);
		 * ratingOfHotel.add(rating); } } hotel.setRatings(ratingOfHotel);
		 */

		return hotel;
	}

}
