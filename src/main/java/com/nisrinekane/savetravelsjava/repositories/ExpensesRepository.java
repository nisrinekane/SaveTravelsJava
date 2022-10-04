package com.nisrinekane.savetravelsjava.repositories;

import com.nisrinekane.savetravelsjava.models.Expenses;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Book;
import java.util.List;

@Repository
public interface ExpensesRepository extends CrudRepository<Expenses, Long> {
    // this method retrieves all the books from the database
    List<Expenses> findAll();
    // this method finds books with descriptions containing the search string
    List<Expenses> findByDescriptionContaining(String search);
    // this method counts how many titles contain a certain string
    Long countByNameContaining(String search);
    // this method deletes a book that starts with a specific title
    Long deleteByNameStartingWith(String search);


}