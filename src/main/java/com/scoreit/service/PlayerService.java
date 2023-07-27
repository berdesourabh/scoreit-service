package com.scoreit.service;

import com.scoreit.model.entity.Player;
import com.scoreit.model.request.PlayerDto;

public interface PlayerService {

    Player create(PlayerDto player) throws Exception;
}
