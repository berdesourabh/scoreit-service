package com.scoreit.controller;

import com.scoreit.model.request.PlayerDto;
import java.util.logging.Logger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/players")
@RequiredArgsConstructor
public class PlayerController {
    private static final Logger LOGGER = Logger.getLogger(PlayerController.class.getName());

    @PostMapping(path = "/")
    public String create(@RequestBody PlayerDto player) throws Exception {
        return "Player Creation request received";
    }
}
