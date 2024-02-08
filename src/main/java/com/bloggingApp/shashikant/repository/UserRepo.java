package com.bloggingApp.shashikant.repository;

import com.bloggingApp.shashikant.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {


}

