package com.project.accounts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountsService {

    @Autowired
    private AccountsRepository accountsRepository;

    public List<Accounts> listAll() {
        return  (List<Accounts>) accountsRepository.findAll();
    }

    public void save(Accounts account) { accountsRepository.save(account); }
}
