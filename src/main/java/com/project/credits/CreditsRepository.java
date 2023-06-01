package com.project.credits;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CreditsRepository extends CrudRepository<Credits, Integer> {
    List<Credits> findCreditsByIdCredit(Integer creditId);
}
