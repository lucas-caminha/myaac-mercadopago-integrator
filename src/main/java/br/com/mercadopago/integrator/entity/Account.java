package br.com.mercadopago.integrator.entity;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "accounts", uniqueConstraints = {
    @UniqueConstraint(name = "accounts_unique", columnNames = "name")
})
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 32, unique = true)
    private String name;

    @Column(name = "password", nullable = false, columnDefinition = "TEXT")
    private String password;

    @Column(name = "email", nullable = false, length = 255)
    private String email = "";

    @Column(name = "premdays", nullable = false)
    private Integer premdays = 0;

    @Column(name = "premdays_purchased", nullable = false)
    private Integer premdaysPurchased = 0;

    @Column(name = "lastday", nullable = false)
    private Integer lastday = 0;

    @Column(name = "type", nullable = false)
    private Short type = 1;

    @Column(name = "coins", nullable = false)
    private Integer coins = 0;

    @Column(name = "coins_transferable", nullable = false)
    private Integer coinsTransferable = 0;

    @Column(name = "tournament_coins", nullable = false)
    private Integer tournamentCoins = 0;

    @Column(name = "creation", nullable = false)
    private Integer creation = 0;

    @Column(name = "recruiter")
    private Integer recruiter = 0;

    @Column(name = "house_bid_id", nullable = false)
    private Integer houseBidId = 0;

    // Getters e Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPremdays() {
        return premdays;
    }

    public void setPremdays(Integer premdays) {
        this.premdays = premdays;
    }

    public Integer getPremdaysPurchased() {
        return premdaysPurchased;
    }

    public void setPremdaysPurchased(Integer premdaysPurchased) {
        this.premdaysPurchased = premdaysPurchased;
    }

    public Integer getLastday() {
        return lastday;
    }

    public void setLastday(Integer lastday) {
        this.lastday = lastday;
    }

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    public Integer getCoins() {
        return coins;
    }

    public void setCoins(Integer coins) {
        this.coins = coins;
    }

    public Integer getCoinsTransferable() {
        return coinsTransferable;
    }

    public void setCoinsTransferable(Integer coinsTransferable) {
        this.coinsTransferable = coinsTransferable;
    }

    public Integer getTournamentCoins() {
        return tournamentCoins;
    }

    public void setTournamentCoins(Integer tournamentCoins) {
        this.tournamentCoins = tournamentCoins;
    }

    public Integer getCreation() {
        return creation;
    }

    public void setCreation(Integer creation) {
        this.creation = creation;
    }

    public Integer getRecruiter() {
        return recruiter;
    }

    public void setRecruiter(Integer recruiter) {
        this.recruiter = recruiter;
    }

    public Integer getHouseBidId() {
        return houseBidId;
    }

    public void setHouseBidId(Integer houseBidId) {
        this.houseBidId = houseBidId;
    }
}
