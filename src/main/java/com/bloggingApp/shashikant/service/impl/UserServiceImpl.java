package com.bloggingApp.shashikant.service.impl;

import com.bloggingApp.shashikant.entity.User;
import com.bloggingApp.shashikant.exception.ResourceNotFound;
import com.bloggingApp.shashikant.payload.UserDto;
import com.bloggingApp.shashikant.repository.UserRepo;
import com.bloggingApp.shashikant.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = this.dtoToUser(userDto);
        User savedUser = this.userRepo.save(user);

        return this.userToDto(savedUser);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer userID) {

        User user = this.userRepo.findById(userID).orElseThrow(() -> new ResourceNotFound("User", "id", userID));

        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setAbout(userDto.getAbout());

        User updatedUser = this.userRepo.save(user);
        UserDto userDto1 = this.userToDto(updatedUser);

        return userDto1;
    }

    @Override
    public UserDto getUserByID(Integer userID) {

        User user = this.userRepo.findById(userID).orElseThrow(() -> new ResourceNotFound("User", "id", userID));

        return this.userToDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {

        List<User> users = this.userRepo.findAll();
        List<UserDto> userDto = users.stream().map(user -> this.userToDto(user)).collect(Collectors.toList());
        return userDto;
    }

    @Override
    public void deleteUserById(Integer userID) {

        User user = this.userRepo.findById(userID).orElseThrow(() -> new ResourceNotFound("User", "id", userID));

        this.userRepo.delete(user);


    }

    private User dtoToUser(UserDto userDto){
        User user = new User();
        user.setId(userDto.getId());
        user.setName((userDto.getName()));
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setAbout(userDto.getAbout());

        return user;

    }

    private UserDto userToDto(User user){

        UserDto userDto = new UserDto();

        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setAbout(user.getAbout());

        return userDto;
    }

}
