package com.programming.spring_boot_mongodb_exercise.config;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.programming.spring_boot_mongodb_exercise.model.Expense;
import com.programming.spring_boot_mongodb_exercise.model.ExpenseCategory;
import com.programming.spring_boot_mongodb_exercise.repository.ExpenseRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static com.programming.spring_boot_mongodb_exercise.model.ExpenseCategory.*;

@ChangeLog
public class DatabaseChangeLog {
    @ChangeSet(order = "001",id="seedDatabase",author = "Milan")
    public void seedDatabase(ExpenseRepository expenseRepository){
        List<Expense> expenses=new ArrayList<>();
        expenses.add(createExpense("Movie tickets",ENTERTAINMENT,BigDecimal.valueOf(30)));
        expenses.add(createExpense("Dinner",RESTAURANT,BigDecimal.valueOf(50)));
        expenses.add(createExpense("Food",GROCERIES,BigDecimal.valueOf(60)));
        expenses.add(createExpense("Internet",UTILITIES,BigDecimal.valueOf(25)));
        expenses.add(createExpense("Gifts",MISC,BigDecimal.valueOf(30)));
        expenses.add(createExpense("Gym ",MISC,BigDecimal.valueOf(30)));

        expenseRepository.insert(expenses);
    }

    private Expense createExpense(String expenseName, ExpenseCategory expenseCategory, BigDecimal expenseAmount){
        Expense e=new Expense();
        e.setExpenseAmount(expenseAmount);
        e.setExpenseCategory(expenseCategory);
        e.setExpenseName(expenseName);
        return e;
    }
}
