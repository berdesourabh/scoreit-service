package com.scoreit.model.request;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlayerDto {
    private String firstName;
    private String lastName;
    private String middleName;
    private Date dateOfBirth;
    private String skill;
    private long mobileNumber;
    private String email;
}
