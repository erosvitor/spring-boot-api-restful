package com.ctseducare.apirestful.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ctseducare.apirestful.model.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

}
