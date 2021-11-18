package com.ctseducare.apirestful.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ctseducare.apirestful.model.Expense;
import com.ctseducare.apirestful.service.ExpenseService;

@RestController
public class ExpenseController {

  @GetMapping("/status")
  String hello() {
    return "I am UP!";
  }
  
  @Autowired
  private ExpenseService service;
  
  @PostMapping(
      value = "/expense",
      consumes = { "application/json", "application/xml", "application/x-yaml" },
      produces = { "application/json", "application/xml", "application/x-yaml" })
  public ResponseEntity<Expense> insert(@Valid @RequestBody Expense expense) {
    Expense result = service.insert(expense);
    return ResponseEntity.ok(result);
  }
  
  @GetMapping(
      value = "/expense",
      produces = { "application/json", "application/xml", "application/x-yaml" })
  public ResponseEntity<List<Expense>> findAll() {
    List<Expense> result = service.findAll();
    return ResponseEntity.ok(result);
  }
  
  @PutMapping(
      value = "/expense",
      consumes = { "application/json", "application/xml", "application/x-yaml" },
      produces = { "application/json", "application/xml", "application/x-yaml" })
  public ResponseEntity<Expense> update(@Valid @RequestBody Expense expense) {
    Expense result = service.update(expense);
    return ResponseEntity.ok(result);
  }
  
  @DeleteMapping(
      value = "/expense/{id}",
      produces = { "application/json", "application/xml", "application/x-yaml" })
  public ResponseEntity<Expense> delete(@PathVariable("id") Long id) {
    Expense result = service.delete(id);
    return ResponseEntity.ok(result);
  }

}