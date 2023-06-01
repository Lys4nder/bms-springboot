package com.project.accounts;

import com.project.user.User;
import jakarta.persistence.*;

@Entity
@Table(name = "Accounts")
public class Accounts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cont")
    private Integer idCont;

    @ManyToOne
    @JoinColumn(name = "id_client")
    private User client;

    @Column(name = "tip_cont", length = 50)
    private String tipCont;

    @Column(name = "sold")
    private Float sold;

    public Accounts(Integer idCont, User client, String tipCont, Float sold) {
        this.idCont = idCont;
        this.client = client;
        this.tipCont = tipCont;
        this.sold = sold;
    }

    public Accounts() {
    }

    public Integer getIdCont() {
        return idCont;
    }

    public void setIdCont(Integer idCont) {
        this.idCont = idCont;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public String getTipCont() {
        return tipCont;
    }

    public void setTipCont(String tipCont) {
        this.tipCont = tipCont;
    }

    public Float getSold() {
        return sold;
    }

    public void setSold(Float sold) {
        this.sold = sold;
    }
}