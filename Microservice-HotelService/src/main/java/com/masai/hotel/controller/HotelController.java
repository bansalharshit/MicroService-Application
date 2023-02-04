package com.masai.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.hotel.entities.Hotel;
import com.masai.hotel.services.HotelServices;

@RestController
@RequestMapping("/hotels")
public class HotelController {

	@Autowired
	private HotelServices hotelServices;
	
	@PostMapping
	public ResponseEntity<Hotel> createHotelHandler(@RequestBody Hotel hotel){
		return ResponseEntity.status(HttpStatus.CREATED).body(hotelServices.create(hotel));
	}
	
	@GetMapping("/{hotelId}")
	public ResponseEntity<Hotel> getHotelDetailsHandler(@PathVariable String hotelId){
		return ResponseEntity.status(HttpStatus.OK).body(hotelServices.getHotelDetails(hotelId));
		
	}
	
	@GetMapping
	public ResponseEntity<List<Hotel>> getAllHotelDetailsHandler(){
		return ResponseEntity.ok(hotelServices.getAllHotelsDetails());
		
	}
}
