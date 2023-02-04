package com.masai.hotel.implementation;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.hotel.entities.Hotel;
import com.masai.hotel.exceptions.ResourceNotFoundException;
import com.masai.hotel.repositories.HotelRepository;
import com.masai.hotel.services.HotelServices;

@Service
public class HotelServiceImpl implements HotelServices {

	@Autowired
	private HotelRepository hotelRepository;
		
	
	@Override
	public Hotel create(Hotel hotel) {
		String hotelId=UUID.randomUUID().toString();
		hotel.setId(hotelId);
		return hotelRepository.save(hotel);
	}

	@Override
	public List<Hotel> getAllHotelsDetails() {
		return hotelRepository.findAll();
	}

	@Override
	public Hotel getHotelDetails(String id) {
		return hotelRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Hotel with given id not found !! "+id));
		
	}

}
