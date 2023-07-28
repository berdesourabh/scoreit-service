package com.scoreit.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import com.scoreit.model.entity.Player;
import com.scoreit.model.enums.SkillType;
import com.scoreit.model.request.PlayerDto;
import com.scoreit.repository.PlayerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PlayerServiceTest {

    @Mock
    private PlayerRepository playerRepository;

    @InjectMocks
    private PlayerServiceImpl playerService;

    @Test
    void testCreateSuccess() throws Exception {
        when(playerRepository.save(any(Player.class)))
                .thenReturn(Player.builder().build());
        playerService.create(PlayerDto.builder().skill(SkillType.BATSMAN.name()).build());
        verify(playerRepository).save(any(Player.class));
    }

    @Test
    void testCreateWithExistingPlayer() {
        when(playerRepository.existsByEmailAndMobileNumber(anyString(), anyLong()))
                .thenReturn(true);
        assertThrows(
                Exception.class,
                () -> playerService.create(
                        PlayerDto.builder().email("test@email.com").build()));
        verify(playerRepository).existsByEmailAndMobileNumber(anyString(), anyLong());
        verify(playerRepository, never()).save(any(Player.class));
    }
}
