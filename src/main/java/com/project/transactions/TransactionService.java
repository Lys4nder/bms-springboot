package com.project.transactions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public List<Transaction> listAll() {
        return (List<Transaction>) transactionRepository.findAll();
    }

    public List<Transaction> findByUserId(Integer userId) {
        return transactionRepository.findByUserId(userId);
    }

    public void save(Transaction transaction) {
        transactionRepository.save(transaction);
    }

    public Transaction get(Integer id) throws TransactionNotFoundException {
        return transactionRepository.findById(id)
                .orElseThrow(() -> new TransactionNotFoundException("Could not find any transaction with ID " + id));
    }
}
