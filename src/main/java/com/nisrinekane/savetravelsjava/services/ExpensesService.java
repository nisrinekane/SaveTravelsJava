package com.nisrinekane.savetravelsjava.services;

import com.nisrinekane.savetravelsjava.models.Expenses;
import com.nisrinekane.savetravelsjava.repositories.ExpensesRepository;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

@Service
public class ExpensesService {
    // adding the expenses repository as a dependency
    private final ExpensesRepository expensesRepository;

    public ExpensesService(ExpensesRepository expensesRepository) {

        this.expensesRepository = expensesRepository;
    }
    // returns all the expense
    public List<Expenses> allExpenses() {
        return expensesRepository.findAll();
    }
    // creates an expense
    public Expenses createExpense(Expenses e) {

        return expensesRepository.save(e);
    }
    // deletes an expense
    public Expenses deleteExpenses(long id) {
        expensesRepository.deleteById(id);
        return null;
    }

    // retrieves an expense
    public Expenses findExpenses(Long id) {
        //optional: could exist or not
        Optional<Expenses> optionalExpenses = expensesRepository.findById(id);
        //old version:
//        if(optionalExpenses.isPresent()) {
//            return optionalExpenses.get();
//        } else {
//            return null;
//        }
        //new version:
        return optionalExpenses.orElse(null);
    }

    public Expenses updateExpenses(Long id, String name, String description, String vendor, Double amount) {
        Expenses expenses = findExpenses(id);
        expenses.setName(name);
        expenses.setDescription(description);
        expenses.setVendor(vendor);
        expenses.setAmount(amount);
        return expensesRepository.save(expenses);
    }
}
