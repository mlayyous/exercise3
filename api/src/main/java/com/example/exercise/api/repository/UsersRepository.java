package com.example.exercise.api.repository;

import com.example.exercise.api.model.Users;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<Users, Long> {
}
