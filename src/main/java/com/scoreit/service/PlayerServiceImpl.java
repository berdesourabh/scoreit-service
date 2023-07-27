package com.scoreit.service;

import com.scoreit.model.entity.Player;
import com.scoreit.model.request.PlayerDto;
import com.scoreit.repository.PlayerRepository;
import com.scoreit.util.MapperUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;

    @Override
    public Player create(PlayerDto player) throws Exception {
        boolean playerExists = playerRepository.findByEmailAndMobileNumber(player.getEmail(), player.getMobileNumber());
        if (playerExists) {
            throw new Exception("Player already exists with id");
        }
        Player newPlayer = MapperUtils.mapToPlayer(player);
        return playerRepository.save(newPlayer);
    }
}
