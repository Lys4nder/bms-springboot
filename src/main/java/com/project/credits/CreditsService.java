package com.project.credits;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CreditsService {

    @Autowired
    private CreditsRepository creditsRepository;

    public void save(Credits credits) { creditsRepository.save(credits); }

    public List<Credits> listAll() {
        return (List<Credits>) creditsRepository.findAll();
    }



}
