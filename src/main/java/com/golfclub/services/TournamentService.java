package com.golfclub.services;

import com.golfclub.models.Player;
import com.golfclub.models.Tournament;
import com.golfclub.repositories.PlayerRepository;
import com.golfclub.repositories.TournamentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TournamentService {

    private final TournamentRepository tournamentRepository;
    private final PlayerRepository playerRepository;

    public TournamentService(TournamentRepository tournamentRepository, PlayerRepository playerRepository) {
        this.tournamentRepository = tournamentRepository;
        this.playerRepository = playerRepository;
    }

    public List<Tournament> getAllTournaments() {
        return tournamentRepository.findAll();
    }

    public Optional<Tournament> getTournamentById(Long id) {
        return tournamentRepository.findById(id);
    }

    public Tournament addTournament(Tournament tournament) {
        return tournamentRepository.save(tournament);
    }

    public Tournament updateTournament(Long id, Tournament updatedTournament) {
        return tournamentRepository.findById(id).map(existing -> {
            existing.setStartDate(updatedTournament.getStartDate());
            existing.setEndDate(updatedTournament.getEndDate());
            existing.setLocation(updatedTournament.getLocation());
            existing.setEntryFee(updatedTournament.getEntryFee());
            existing.setCashPrize(updatedTournament.getCashPrize());
            existing.setPlayers(updatedTournament.getPlayers());
            return tournamentRepository.save(existing);
        }).orElseThrow(() -> new RuntimeException("Tournament not found: " + id));
    }

    public void deleteTournament(Long id) {
        tournamentRepository.deleteById(id);
    }

    public List<Tournament> searchByLocation(String location) {
        return tournamentRepository.findByLocationContainingIgnoreCase(location);
    }

    public List<Tournament> searchByStartDate(LocalDate startDate) {
        return tournamentRepository.findByStartDate(startDate);
    }

    public Tournament addPlayerToTournament(Long tournamentId, Long playerId) {
        Tournament tournament = tournamentRepository.findById(tournamentId)
                .orElseThrow(() -> new RuntimeException("Tournament not found: " + tournamentId));

        Player player = playerRepository.findById(playerId)
                .orElseThrow(() -> new RuntimeException("Player not found: " + playerId));

        tournament.getPlayers().add(player);
        return tournamentRepository.save(tournament);
    }

    public Tournament removePlayerFromTournament(Long tournamentId, Long playerId) {
        Tournament tournament = tournamentRepository.findById(tournamentId)
                .orElseThrow(() -> new RuntimeException("Tournament not found: " + tournamentId));

        Player player = playerRepository.findById(playerId)
                .orElseThrow(() -> new RuntimeException("Player not found: " + playerId));

        tournament.getPlayers().remove(player);
        return tournamentRepository.save(tournament);
    }
}
