package com.masai.user.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.masai.user.service.entities.Rating;
import com.masai.user.service.external.services.RatingService;

@SpringBootTest
class MicroserviceUserServiceApplicationTests {
private Calculator c=new Calculator();
	
	@Test
	void contextLoads() {
	}
	
	@Autowired
	private RatingService ratingService;
	
//	@Test
//	void createRating() {
//	Rating rating=Rating.builder().rating(10).userId("").hotelId("").feedback("this is created using feign client").build();	
//	Rating savedRating=ratingService.createRating(rating);
//	System.out.println("new rating created");
//	}
	
	@Test
	void testSum() {
		
		// expected result
		int expectedResult=17;
		
		//acutal
		int acutalResult=c.doSum(12, 3, 2);
		assertThat(acutalResult).isEqualTo(expectedResult);
	}
	
	@Test
	void testProduct() {
		int expectedResult=35;
		int acutalResult=c.doMult(7, 5);
		assertThat(acutalResult).isEqualTo(expectedResult);
	}

}
