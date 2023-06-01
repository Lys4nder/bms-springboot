package com.project.payments;

import com.project.credits.Credits;
import jakarta.persistence.*;

@Entity
@Table(name = "Payments")
public class Payments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_plata")
    Integer idPlata;

    @ManyToOne
    @JoinColumn(name = "id_credit")
    private Credits credit;

    @Column(name = "suma_platita")
    private double sumaPlatita;

    @Column(name = "data_plata")
    private String data;


}
