package com.example.demo.service;

import com.example.demo.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository     //Đánh dấu Class giao tiếp với table Users trong database
public interface UsersService extends JpaRepository<Users, Integer> {
}
