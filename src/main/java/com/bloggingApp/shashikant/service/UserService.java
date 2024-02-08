package com.bloggingApp.shashikant.service;

import com.bloggingApp.shashikant.payload.UserDto;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto userDto);
    UserDto updateUser(UserDto user, Integer userID);
    UserDto getUserByID( Integer userID);
    List<UserDto> getAllUsers();
    void deleteUserById(Integer userID);

}
