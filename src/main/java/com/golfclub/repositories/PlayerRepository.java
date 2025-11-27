package com.golfclub.repositories;

import com.golfclub.models.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player,Long>{
    List<Player> findByPlayerNameContainingIgnoreCase(String name);

    List<Player> findByPhoneContaining(String phone);

    List<Player> findByMembershipStartDate(LocalDate startDate);

    List<Player> findByMembershipTypeIgnoreCase(String membershipType);
}
