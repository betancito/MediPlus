package com.appointments.medical.controller;

import com.appointments.medical.dto.request.UserReq;
import com.appointments.medical.dto.response.UserRes;
import com.appointments.medical.model.entity.User;
import com.appointments.medical.model.enums.userRole;
import com.appointments.medical.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth")
public class AuthContoller {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    @Operation(description = "login endpoint")
    @ApiResponse(responseCode = "200", description = "User logged in successfully")
    @ApiResponse(responseCode = "400", description = "Unable to log in user")
    public String login(@Parameter String password, @Parameter String username){
        User user = new User();
        user.setPassword(password);
        user.setUsername(username);
        User user1 = userService.getUserByUsername(username);
        if (user1 == null) {
            throw new IllegalArgumentException("Usuario no encontrado: " + username);
        }
        user.setRole(user1.getRole());
        return userService.verify(user);
    }

    @PostMapping("/register")
    @Operation(description = "Public Register endpoint")
    @ApiResponse(responseCode = "201", description = "User created successfully")
    @ApiResponse(responseCode = "400", description = "Unable to create user")
    public UserRes createUser(@Parameter String username, @Parameter String password, @Parameter userRole role){
        UserReq userReq = new UserReq(username, password, role);
        return userService.saveUser(userReq);
    }
}
