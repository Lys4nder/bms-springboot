package com.project.credits;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CreditsRepository extends CrudRepository<Credits, Integer> {
    List<Credits> findCreditsByIdCredit(Integer creditId);
    List<Credits> findCreditsByUser(Integer user);

    @Query("SELECT c FROM Credits c")
    List<Credits> listAll();

    List<Credits> findCreditsByUser_Id(Integer userId);


}
