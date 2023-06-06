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

    public Payments(Integer idPlata, Credits credit, double sumaPlatita, String data) {
        this.idPlata = idPlata;
        this.credit = credit;
        this.sumaPlatita = sumaPlatita;
        this.data = data;
    }

    public Payments() {
    }

    @Override
    public String toString() {
        return "Payments{" +
                "idPlata=" + idPlata +
                ", credit=" + credit +
                ", sumaPlatita=" + sumaPlatita +
                ", data='" + data + '\'' +
                '}';
    }

    public Integer getIdPlata() {
        return idPlata;
    }

    public void setIdPlata(Integer idPlata) {
        this.idPlata = idPlata;
    }

    public Credits getCredit() {
        return credit;
    }

    public void setCredit(Credits credit) {
        this.credit = credit;
    }

    public double getSumaPlatita() {
        return sumaPlatita;
    }

    public void setSumaPlatita(double sumaPlatita) {
        this.sumaPlatita = sumaPlatita;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
