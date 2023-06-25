package com.project.transactions;

import com.project.user.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Integer> {

    List<Transaction> findByUserId(Integer userId);

    List<Transaction> findByUser(User user);

    List<Transaction> findFirst10ByOrderByDateDesc();
}
