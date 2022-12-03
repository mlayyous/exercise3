package com.example.exercise.api.service;

import com.example.exercise.api.model.ServiceSpending;
import com.example.exercise.api.model.Spending;
import com.example.exercise.api.repository.SpendingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class SpendingServiceImpl implements SpendingService {

  private final SpendingRepository repository;

  public SpendingServiceImpl(SpendingRepository repository) {
    this.repository = repository;
  }

  @Override
  public List<Spending> getSpending() {
    return StreamSupport.stream(repository.findAll().spliterator(), false)
            .collect(Collectors.toList());
  }

  @Override
  public List<ServiceSpending> getServiceSpending() {
    return this.getSpending().stream()
            .collect(Collectors.groupingBy(Spending::getService,
                    Collectors.summingDouble(Spending::getNetAmount)))
            .entrySet()
            .stream().map(a -> new ServiceSpending(a.getKey(), a.getValue()))
            .collect(Collectors.toList());
  }
}
