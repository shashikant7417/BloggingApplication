package com.bloggingApp.shashikant.controller;

import com.bloggingApp.shashikant.payload.ApiResponse;
import com.bloggingApp.shashikant.payload.UserDto;
import com.bloggingApp.shashikant.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // POST Create User

    @PostMapping("/createUser")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {

        UserDto createdUser = this.userService.createUser(userDto);

        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);

    }

    // PUT Update User

    @PutMapping("/updateUser/{userId}")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto, @PathVariable Integer userId) {

        UserDto updatedUser = this.userService.updateUser(userDto, userId);

        return new ResponseEntity<>(updatedUser, HttpStatus.OK);

    }

    // DELETE Delete User
    @DeleteMapping("/delete/{userID}")

    public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer userID) {
        this.userService.deleteUserById(userID);

        return new ResponseEntity<>(new ApiResponse("User Deleted Successfully", true), HttpStatus.OK);

    }


    // GET All Users

    @GetMapping("/getUsers")
    public ResponseEntity<List<UserDto>> getAllUsers() {

        List<UserDto> allUsers = this.userService.getAllUsers();

        return new ResponseEntity<>(allUsers, HttpStatus.OK);

    }

    // Get User bu Id
    @GetMapping("/getUser/{userID}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Integer userID) {

        UserDto user = this.userService.getUserByID(userID);

        return new ResponseEntity<>(user, HttpStatus.OK);

    }


}
