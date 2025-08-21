package com.aja.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aja.dto.UserInfoDto;
import com.aja.service.UserInfoServiceImpl;

@RestController
@RequestMapping("/user")
public class UserInfoController {

	@Autowired
	private UserInfoServiceImpl userInfoService;

	@PostMapping("/saveuser")
	public ResponseEntity<UserInfoDto> saveUserDto(@RequestBody UserInfoDto userDto) {
		UserInfoDto saveUserDto = userInfoService.saveUserDto(userDto);
		return ResponseEntity.ok(saveUserDto);
	}

	@PutMapping("/edituser/{id}")
	public ResponseEntity<UserInfoDto> updateUserDto(@PathVariable int id, @RequestBody UserInfoDto userDto) {
		UserInfoDto updateUserDto = userInfoService.updateUserDto(id, userDto);
		return ResponseEntity.ok(updateUserDto);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<UserInfoDto> getUserById(@PathVariable int id) {
		UserInfoDto userById = userInfoService.getUserById(id);
		return ResponseEntity.ok(userById);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<UserInfoDto>> getAllUser() {
		List<UserInfoDto> allUser = userInfoService.getAllUser();
		return ResponseEntity.ok(allUser);
	}

	@DeleteMapping("/remove/{id}")
	public String deleteUserById(@PathVariable int id) {
		userInfoService.deleteUserById(id);
		return "User Id " + id + " is deleted";
	}

	@DeleteMapping("/removeAll")
	public String deleteAllUsers() {
		userInfoService.deleteAllUsers();
		return "All users deleted ";
	}
}
