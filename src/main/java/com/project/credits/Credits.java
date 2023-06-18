package com.project.credits;

import com.project.user.User;
import jakarta.persistence.*;

@Entity
@Table(name = "Credits")
public class Credits {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_credit")
    private Integer idCredit;

    @ManyToOne
    @JoinColumn(name = "id_client")
    private User user;

    @Column(name = "suma_credit")
    private double sumaCredit;

    @Column(name = "dobanda")
    private double dobanda;

    @Column(name = "durata")
    private int durata;

    public Credits(Integer idCredit, User user, double sumaCredit, double dobanda, int durata) {
        this.idCredit = idCredit;
        this.user = user;
        this.sumaCredit = sumaCredit;
        this.dobanda = dobanda;
        this.durata = durata;
    }

    public Credits() {
    }

    public Integer getIdCredit() {
        return idCredit;
    }

    public void setIdCredit(Integer idCredit) {
        this.idCredit = idCredit;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getSumaCredit() {
        return sumaCredit;
    }

    public void setSumaCredit(double sumaCredit) {
        this.sumaCredit = sumaCredit;
    }

    public double getDobanda() {
        return dobanda;
    }

    public void setDobanda(double dobanda) {
        this.dobanda = dobanda;
    }

    public int getDurata() {
        return durata;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }
}
