package com.scoreit.repository;

import com.scoreit.model.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    boolean findByEmailAndMobileNumber(@Param("email") String email, @Param("mobileNumber") long mobileNumber);
}
