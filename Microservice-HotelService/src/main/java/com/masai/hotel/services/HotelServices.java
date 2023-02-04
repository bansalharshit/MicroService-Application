package com.masai.hotel.services;

import java.util.List;

import com.masai.hotel.entities.Hotel;

public interface HotelServices {
public Hotel create(Hotel hotel);
public List<Hotel> getAllHotelsDetails();
public Hotel getHotelDetails(String id);

}
