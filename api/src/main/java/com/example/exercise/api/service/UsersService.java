package com.example.exercise.api.service;

import com.example.exercise.api.model.Users;

import java.util.List;

public interface UsersService {

  List<Users> getUsers();
  Users getUser(Long id);

}
