package com.golfclub.models;

import jakarta.persistence.*;

@Entity
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int strokes;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;

    @ManyToOne
    @JoinColumn(name = "tournament_id")
    private Tournament tournament;

    public Score() {}

    public Score(int strokes, Player player, Tournament tournament) {
        this.strokes = strokes;
        this.player = player;
        this.tournament = tournament;
    }

    // Getters & Setters
    public Long getId() { return id; }

    public int getStrokes() {return strokes;}
    public void setStrokes(int strokes) {this.strokes = strokes;}

    public Player getPlayer() {return player;}
    public void setPlayer(Player player) {this.player = player;}

    public Tournament getTournament() {return tournament;}
    public void setTournament(Tournament tournament) { this.tournament = tournament;}
}
