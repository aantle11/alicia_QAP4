package com.golfclub.models;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Tournament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate startDate;
    private LocalDate endDate;
    private String location;
    private double entryFee;
    private double cashPrize;

    @ManyToMany
    @JoinTable(
            name = "tournament_players",
            joinColumns = @JoinColumn(name = "tournament_id"),
            inverseJoinColumns = @JoinColumn(name = "player_id")
    )
    private Set<Player> players = new HashSet<>();

    public Tournament() {}

    public Tournament(LocalDate startDate, LocalDate endDate, String location, double entryFee, double cashPrize) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.location = location;
        this.entryFee = entryFee;
        this.cashPrize = cashPrize;
    }

    // Getters & Setters
    public Long getId() {return id;}

    public LocalDate getStartDate() {return startDate;}
    public void setStartDate(LocalDate startDate) {this.startDate = startDate;}

    public LocalDate getEndDate() {return endDate;}
    public void setEndDate(LocalDate endDate) {this.endDate = endDate;}

    public String getLocation() {return location;}
    public void setLocation(String location) {this.location = location;}

    public double getEntryFee() {return entryFee;}
    public void setEntryFee(double entryFee) {this.entryFee = entryFee;}

    public double getCashPrize() {return cashPrize;}
    public void setPlayers(Set<Player> players) {this.players = players;}
}
