package com.project.transactions;

import com.project.user.User;
import com.project.user.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Optional<Transaction> result = transactionRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new TransactionNotFoundException("Could not find any transaction with ID " + id);
    }
}
