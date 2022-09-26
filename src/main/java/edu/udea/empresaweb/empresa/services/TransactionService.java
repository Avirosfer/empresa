package edu.udea.empresaweb.empresa.services;


import edu.udea.empresaweb.empresa.entities.Transaction;
import java.util.List;

public interface TransactionService {

    List<Transaction> getAllTransactions();
    void saveTransaction(Transaction transaction);
    Transaction getTransactionById(long id);
    void deleteTransactionById(long id);

}
