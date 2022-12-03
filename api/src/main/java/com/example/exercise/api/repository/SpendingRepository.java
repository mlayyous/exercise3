package com.example.exercise.api.repository;

import com.example.exercise.api.model.Spending;
import org.springframework.data.repository.CrudRepository;

public interface SpendingRepository extends CrudRepository<Spending, Long> {
}
