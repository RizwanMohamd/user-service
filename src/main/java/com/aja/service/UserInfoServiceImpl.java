package com.aja.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aja.ECommerceApplication;

import com.aja.dto.UserInfoDto;
import com.aja.entity.UserInfo;
import com.aja.repo.UserRepository;

@Service
public class UserInfoServiceImpl implements UserInfoService {

	private final ECommerceApplication ECommerceApplication;

	@Autowired
	private UserRepository userRepo;

	UserInfoServiceImpl(ECommerceApplication ECommerceApplication) {
		this.ECommerceApplication = ECommerceApplication;
	}

	@Override
	public UserInfoDto saveUserDto(UserInfoDto userDto) {
		UserInfo user = new UserInfo();
		BeanUtils.copyProperties(userDto, user);
		UserInfo save = userRepo.save(user);
		UserInfoDto dto = new UserInfoDto();
		BeanUtils.copyProperties(save, dto);
		return dto;
	}

	@Override
	public UserInfoDto updateUserDto(int id, UserInfoDto userDto) {
		UserInfo user = userRepo.findById(id).orElseThrow(() -> new RuntimeException("User ID " + id + " not found"));
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setGender(userDto.getGender());
		user.setDateOfBirth(userDto.getDateOfBirth());
		user.setEmail(userDto.getEmail());
		user.setPhone(userDto.getPhone());
		user.setAddress(userDto.getAddress());
		user.setRole(userDto.getRole());
		user.setPassword(userDto.getPassword());
		user.setImage(userDto.getImage());
		user = userRepo.save(user);
		UserInfoDto updatedDto = new UserInfoDto();
		BeanUtils.copyProperties(user, updatedDto);
		return updatedDto;
	}

	@Override
	public UserInfoDto getUserById(int id) {
		UserInfo getid = userRepo.findById(id).orElseThrow(() -> new RuntimeException("User ID " + id + " not found"));
		UserInfoDto dto = new UserInfoDto();
		BeanUtils.copyProperties(getid, dto);
		return dto;

	}

	@Override
	public List<UserInfoDto> getAllUser() {
		List<UserInfo> allUsers = userRepo.findAll();
		List<UserInfoDto> userDtoList = new ArrayList<UserInfoDto>();

		for (UserInfo user : allUsers) {
			UserInfoDto dto = new UserInfoDto();
			BeanUtils.copyProperties(user, dto);
			userDtoList.add(dto);
		}

		return userDtoList;
	}


	@Override
	public String deleteUserById(int id) {
		UserInfo user = userRepo.findById(id).orElseThrow(() -> new RuntimeException("User ID " + id + " not found"));
		userRepo.deleteById(id);
		return "User ID " + id + " deleted successfully.";
	}

	@Override
	public String deleteAllUsers() {
		userRepo.deleteAll();
		return "All users deleted successfully.";
	}

}
