package com.golfclub.models;

import jakarta.persistence.*;

import javax.annotation.processing.Generated;
import java.time.LocalDate;

@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String playerName;
    private String address;
    private String email;
    private String phone;

    private LocalDate membershipStartDate;
    private int membershipDurationMonths;

    public Player() {}

    public Player(String playerName, String address, String email, String phone, LocalDate membershipStartDate, int membershipDurationMonths) {
        this.playerName = playerName;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.membershipStartDate = membershipStartDate;
        this.membershipDurationMonths = membershipDurationMonths;
    }

    // Getters & Setters
    public Long getId() { return id; }

    public String getPlayerName() { return playerName; }
    public void setPlayerName(String playerName) { this.playerName = playerName; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public LocalDate getMembershipStartDate() { return membershipStartDate; }
    public void setMembershipStartDate(LocalDate membershipStartDate) { this.membershipStartDate = membershipStartDate; }

    public int getMembershipDurationMonths() { return membershipDurationMonths; }
    public void setMembershipDurationMonths(int membershipDurationMonths) {}
}
