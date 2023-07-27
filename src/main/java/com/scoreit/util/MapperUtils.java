package com.scoreit.util;

import com.scoreit.model.entity.Player;
import com.scoreit.model.enums.SkillType;
import com.scoreit.model.request.PlayerDto;

public class MapperUtils {

    public static Player mapToPlayer(PlayerDto dto) {
        return Player.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .middleName(dto.getMiddleName())
                .dateOfBirth(dto.getDateOfBirth())
                .skill(SkillType.valueOf(dto.getSkill()))
                .build();
    }
}
