package com.golfclub.services;

import com.golfclub.models.Player;
import com.golfclub.repositories.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> findAll() {
        return playerRepository.findAll();
    }

    public Optional<Player> findById(Long id) {
        return playerRepository.findById(id);
    }

    public Player addPlayer(Player player) {
        return playerRepository.save(player);
    }

    public List<Player> searchByName(String name) {
        return playerRepository.findByPlayerNameContainingIgnoreCase(name);
    }

    public List<Player> searchByMembershipType(String membershipType) {
        return playerRepository.findByMembershipTypeIgnoreCase(membershipType);
    }

    public Optional<Player> updatePlayer(Long id, Player updatedPlayer) {
        return playerRepository.findById(id).map(existingPlayer -> {

            existingPlayer.setPlayerName(updatedPlayer.getPlayerName());
            existingPlayer.setAddress(updatedPlayer.getAddress());
            existingPlayer.setEmail(updatedPlayer.getEmail());
            existingPlayer.setPhone(updatedPlayer.getPhone());
            existingPlayer.setMembershipType(updatedPlayer.getMembershipType());
            existingPlayer.setMembershipStartDate(updatedPlayer.getMembershipStartDate());
            existingPlayer.setMembershipDurationMonths(updatedPlayer.getMembershipDurationMonths());

            return playerRepository.save(existingPlayer);
        });
    }

    public boolean deletePlayer(Long id) {
        return playerRepository.findById(id).map(player -> {
            playerRepository.delete(player);
            return true;
        }).orElse(false);
    }
}
