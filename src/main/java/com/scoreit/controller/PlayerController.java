package com.scoreit.controller;

import com.scoreit.model.entity.Player;
import com.scoreit.model.request.PlayerDto;
import com.scoreit.service.PlayerServiceImpl;
import java.util.logging.Logger;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/players")
@RequiredArgsConstructor
public class PlayerController {
    private static final Logger LOGGER = Logger.getLogger(PlayerController.class.getName());

    private final PlayerServiceImpl playerService;

    @PostMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Player create(@RequestBody PlayerDto player) throws Exception {
        LOGGER.info("Received player creation request");
        return playerService.create(player);
    }
}
