package com.example.exercise.api.service;

import com.example.exercise.api.model.Users;
import com.example.exercise.api.repository.UsersRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UsersServiceImpl implements UsersService {

  private final UsersRepository repository;

  public UsersServiceImpl(UsersRepository repository) {
    this.repository = repository;
  }

  @Override
  public List<Users> getUsers(){
    return StreamSupport.stream(repository.findAll().spliterator(), false)
            .collect(Collectors.toList());
  }

  @Override
  public Users getUser(Long id) {
    return repository.findById(id).orElseThrow(() -> new EntityNotFoundException(id+""));

  }

}
