package com.nisrinekane.savetravelsjava.controllers;

import com.nisrinekane.savetravelsjava.models.Expenses;
import com.nisrinekane.savetravelsjava.models.Expenses;
import com.nisrinekane.savetravelsjava.services.ExpensesService;
import com.nisrinekane.savetravelsjava.services.ExpensesService;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@Controller
public class MainController {
    @Autowired
    ExpensesService expensesService;

    //show one expense
    @GetMapping("/expenses/{expenseId}")
    public String index(Model model, @PathVariable("expenseId") Long expenseId) {
        System.out.println(expenseId);
        Expenses expenses = expensesService.findExpenses(expenseId);
        System.out.println(expenses);
        model.addAttribute("expenses", expenses);
        return "show.jsp";
    }

    //show all expenses
    @RequestMapping("/expenses")
    public String index(Model model,
                        @ModelAttribute("expense") Expenses expense) {
        List<Expenses> expenses = expensesService.allExpenses();
        model.addAttribute("expenses", expenses);
        return "index.jsp";
    }

    //post method to create an expense using inversion of control, Binding result for errors
    @PostMapping("/expense")
    public String create(@Valid @ModelAttribute("expense") Expenses expense, BindingResult result) {
        if (result.hasErrors()) {
            return "index.jsp";
        }
        expensesService.createExpense(expense);
        return "redirect:/expenses/";
    }

    //update expense: get the target expense/render the form
    @RequestMapping("/expenses/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        Expenses expense = expensesService.findExpenses(id);
        System.out.println(expense);
        model.addAttribute("expense", expense);
        return "edit.jsp";
    }

    //process the update request
    @PutMapping ("/expenses/{id}")
    public String update(@Valid @ModelAttribute("expense") Expenses expense, BindingResult result) {
        if (result.hasErrors()) {
            return "edit.jsp";
        } else {
            expensesService.updateExpenses(expense.getId(), expense.getName(), expense.getDescription(),expense.getVendor(), expense.getAmount());
            return "redirect:/expenses";
        }
    }

    //delete an exepnse
    @DeleteMapping("/expenses/{id}")
    public String destroy(@PathVariable("id") Long id) {
        expensesService.deleteExpenses(id);
        return "redirect:/expenses";
    }
}




