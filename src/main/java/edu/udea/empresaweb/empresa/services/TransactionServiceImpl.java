package edu.udea.empresaweb.empresa.services;



import edu.udea.empresaweb.empresa.entities.Transaction;
import edu.udea.empresaweb.empresa.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    @Override
    public void saveTransaction(Transaction transaction) {
        this.transactionRepository.save(transaction);
    }

    @Override
    public Transaction getTransactionById(long id) {
        Optional<Transaction> optional = transactionRepository.findById(id);
        Transaction transaction = null;
        if (optional.isPresent()) {
            transaction = optional.get();
        } else {
            throw new RuntimeException(" Transaction not found for id :: " + id);
        }
        return transaction;
    }

    @Override
    public void deleteTransactionById(long id) {
        this.transactionRepository.deleteById(id);
    }
}
