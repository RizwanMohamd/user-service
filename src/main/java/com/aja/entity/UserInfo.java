package com.aja.entity;

import java.util.Date;

import com.aja.enums.Role;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String firstName;
	private String lastName;
	private String middleName;
	private String gender;
	private Date dateOfBirth;
	private String email;
	private String phone;
	private String address;
	private String password;
	private String image;
	private String trainString;
	private String rizwanString;

//	@ManyToOne
	@Enumerated(EnumType.STRING)
	private Role role;

	// manytomany
	// role -> admin, user
}
