package com.project;

import com.project.transactions.Transaction;
import com.project.transactions.TransactionRepository;
import com.project.user.User;
import com.project.user.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = true)
public class TransactionRepositoryTest {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void TestAddNew() {
        User user = new User();
        user.setEmail("test388@gmail.com");
        user.setPassword("12345");
        user.setFirstName("Tester");
        user.setLastName("Testing");
        userRepository.save(user);
        Transaction transaction = new Transaction();
        transaction.setAmount(123.04f);
        transaction.setDate("10/10/2020");
        transaction.setUser(user);
        Transaction savedTransaction = transactionRepository.save(transaction);

        Assertions.assertNotNull(savedTransaction);
        Assertions.assertNotNull(savedTransaction.getId());
    }

    @Test
    public void TestListAll() {
        Iterable<Transaction> transactions = transactionRepository.findAll();
        Assertions.assertNotNull(transactions);

        for (Transaction transaction : transactions)
            System.out.println(transaction);
    }

    @Test
    public void TestGet() {
        Optional<Transaction> transaction = transactionRepository.findById(1);
        Assertions.assertTrue(transaction.isPresent());
        System.out.println(transaction.get());
    }
    
    @Test
    public void TestUpdate() {
        Optional<Transaction> transactionOptional = transactionRepository.findById(1);
        Transaction transaction = transactionOptional.get();
        transaction.setAmount(499.99f);
        Assertions.assertEquals(transactionRepository.findById(1).get().getAmount(), 499.99f);
    }

}
