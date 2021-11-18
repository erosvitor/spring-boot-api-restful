package com.ctseducare.apirestful.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctseducare.apirestful.exception.ResourceNotFoundException;
import com.ctseducare.apirestful.model.Expense;
import com.ctseducare.apirestful.repository.ExpenseRepository;

@Service
public class ExpenseService {

  @Autowired
  private ExpenseRepository repository;
  
  public Expense insert(Expense expense) {
    return repository.save(expense);
  }
  
  public List<Expense> findAll() {
    return repository.findAll();
  }
  
  public Expense update(Expense expense) {
    repository
      .findById(expense.getId())
      .orElseThrow(() -> new ResourceNotFoundException("Expense does not exist!"));
    return repository.save(expense);
  }
  
  public Expense delete(Long id) {
    Expense expense = repository
      .findById(id)
      .orElseThrow(() -> new ResourceNotFoundException("Expense does not exist!"));
    repository.deleteById(id);
    return expense;
  }
  
}
