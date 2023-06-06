package com.project.payments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentsService {

    @Autowired
    private PaymentsRepository paymentsRepository;

    public List<Payments> listAll() { return (List<Payments>) paymentsRepository.findAll(); }


    public void save(Payments payment) { paymentsRepository.save(payment); }
}
