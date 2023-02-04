package com.masai.user.service.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="micro_users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class User {

	@Id
	@Column(name="ID")
	private String userId;
	
	@Column(name="NAME",length=20)
	private String name;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="ABOUT")
	private String about;
	
	@Transient
	private List<Rating> ratings=new ArrayList<>();
	
}
