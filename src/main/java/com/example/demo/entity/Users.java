package com.example.demo.entity;

import jakarta.persistence.*;

@Entity     //Đánh dấu Class map với table User trong database
public class Users {
    @Id     //Đánh dấu cột id
    @GeneratedValue(strategy = GenerationType.IDENTITY)     //các bản ghi được tăng tự động
    @Column(name = "UserId")
    private int id;
    private String username;
    private String email;

    private String password;
    private String name;
    private String address;
    private String phone;
    private String status;
    private String role;
    private String remember;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRemember() {
        return remember;
    }

    public void setRemember(String remember) {
        this.remember = remember;
    }
}
