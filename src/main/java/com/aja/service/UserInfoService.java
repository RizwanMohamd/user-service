package com.aja.service;

import java.util.List;

import com.aja.dto.UserInfoDto;
import com.aja.entity.UserInfo;


public interface UserInfoService {

	public UserInfoDto saveUserDto(UserInfoDto userDto);

	public UserInfoDto updateUserDto(int id, UserInfoDto userDto);

	public UserInfoDto getUserById(int id);

	public List<UserInfoDto> getAllUser();

	public String deleteUserById(int id);

	public String deleteAllUsers();
}
