package com.scoreit.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.scoreit.model.entity.Player;
import com.scoreit.model.enums.SkillType;
import com.scoreit.model.request.PlayerDto;
import com.scoreit.service.PlayerServiceImpl;
import java.util.Date;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@WebMvcTest(controllers = {PlayerController.class})
@ActiveProfiles("test")
class PlayerControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private PlayerServiceImpl playerService;

    private final ObjectMapper mapper = new ObjectMapper();

    @Test
    void testCreateSuccess() throws Exception {
        Player player = Player.builder()
                .firstName("firstName")
                .middleName("middleName")
                .lastName("lastName")
                .dateOfBirth(new Date())
                .skill(SkillType.BATSMAN)
                .email("test@email.com")
                .mobileNumber(123456789)
                .build();
        Mockito.when(playerService.create(ArgumentMatchers.any(PlayerDto.class)))
                .thenReturn(player);
        MvcResult mvcResult = mvc.perform(post("/players/")
                        .content(mapper.writeValueAsString(PlayerDto.builder().build()))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        Player responsePlayer = mapper.readValue(mvcResult.getResponse().getContentAsString(), Player.class);
        assertPlayerResponse(player, responsePlayer);
    }

    private static void assertPlayerResponse(Player player, Player responsePlayer) {
        assertEquals(player.getFirstName(), responsePlayer.getFirstName());
        assertEquals(player.getLastName(), responsePlayer.getLastName());
        assertEquals(player.getMiddleName(), responsePlayer.getMiddleName());
        assertEquals(player.getDateOfBirth(), responsePlayer.getDateOfBirth());
        assertEquals(player.getSkill(), responsePlayer.getSkill());
    }
}
