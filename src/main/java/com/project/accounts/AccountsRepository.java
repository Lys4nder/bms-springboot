package com.project.accounts;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AccountsRepository extends CrudRepository<Accounts, Integer> {
    List<Accounts> findAccountsByIdCont(Integer id);
}


