package com.appointments.medical.dto.response;

import com.appointments.medical.model.enums.userRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRes {
    private String username;

    private userRole role;
}
