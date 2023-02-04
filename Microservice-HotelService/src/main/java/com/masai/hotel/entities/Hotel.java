package com.masai.hotel.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="hotels")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Hotel {

	@Id
	private String id;
	private String name;
	private String location;
	private String about;
}
