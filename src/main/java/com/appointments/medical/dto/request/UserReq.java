package com.appointments.medical.dto.request;

import com.appointments.medical.model.enums.userRole;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserReq {
    private String username;

    private String password;

    private userRole role;
}
