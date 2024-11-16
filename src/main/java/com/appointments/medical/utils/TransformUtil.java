package com.appointments.medical.utils;

import com.appointments.medical.dto.request.UserReq;
import com.appointments.medical.dto.response.UserRes;
import com.appointments.medical.model.entity.User;
import org.springframework.stereotype.Component;

@Component
public class TransformUtil {
    //Utils to transform Users
    //to userEntity from UserRequest
    public User transformToUser(UserReq userReq){
        return User.builder()
                .username(userReq.getUsername())
                .password(userReq.getPassword())
                .role(userReq.getRole())
                .build();
    }

    //to userResponse from UserEntity
    public UserRes transformUserRes(User userEntity){
        return UserRes.builder()
                .username(userEntity.getUsername())
                .role(userEntity.getRole())
                .build();
    }
}
