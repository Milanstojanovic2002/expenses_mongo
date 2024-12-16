package com.programming.spring_boot_mongodb_exercise.service;

import com.programming.spring_boot_mongodb_exercise.model.Expense;
import com.programming.spring_boot_mongodb_exercise.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public void addExpense(Expense expense) {
        expenseRepository.insert(expense);
    }

    public void updateExpense(Expense expense) {
        Expense e=expenseRepository.findById(expense.getId())
                .orElseThrow(()->new RuntimeException(String.format("Cannot find expense by id %s",expense.getId())));
        e.setExpenseName(expense.getExpenseName());
        e.setExpenseCategory(expense.getExpenseCategory());
        e.setExpenseAmount(expense.getExpenseAmount());
        expenseRepository.save(e);
    }

    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    public Expense getExpenseByName(String name) {
        return expenseRepository.findByName(name)
                .orElseThrow(()->new RuntimeException(String.format("Cannot find expense by id %s",name)));

    }

    public void deleteExpense(String id) {
        expenseRepository.deleteById(id);
    }
}
