package com.aja.dto;

import java.util.Date;

import com.aja.enums.Role;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoDto {

	@NotBlank(message = "First name is mandatory")
	@Size(min = 3, max = 50, message = "First name must be between 3 and 15 characters")
	private String firstName;

	@NotBlank(message = "Middle name is mandatory")
	@Size(min = 3, max = 50, message = "First name must be between 3 and 15 characters")
	private String middleName;

	@NotBlank(message = "Last name is mandatory")
	@Size(min = 2, max = 50, message = "Last name must be between 2 and 15 characters")
	private String lastName;

	@NotBlank(message = "Gender is mandatory")
	@Pattern(regexp = "Male|Female|Other", message = "Gender must be Male, Female or Other")
	private String gender;

	@NotNull(message = "Date of birth is mandatory")
	private Date dateOfBirth;

	@NotBlank(message = "Email is mandatory")
//	@Email(message = "Email should be valid")
	private String email;

	@NotNull(message = "Phone number is mandatory")
	@Pattern(regexp = "\\d{10,12}", message = "Phone number must be between 10 and 12 digits")
	private String phone;

	@NotBlank(message = "Address is mandatory")
	private String address;

	private Role role;

	@Pattern(regexp = "^(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()_+=\\-{}\\[\\]:;\"'<>,.?/]).{6,100}$", message = "Password must be 6–100 characters long and include at least one uppercase letter, one number, and one special character")
	@NotBlank(message = "Password is mandatory")
	private String password;

	@Size(max = 255, message = "Image URL must be at most 255 characters")
	private String image; // store as a URL or base64 string path

}
