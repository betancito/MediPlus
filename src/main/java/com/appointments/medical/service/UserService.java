package com.appointments.medical.service;

import com.appointments.medical.dto.request.UserReq;
import com.appointments.medical.dto.response.UserRes;
import com.appointments.medical.model.entity.User;
import com.appointments.medical.repository.UserRepository;
import com.appointments.medical.utils.TransformUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private TransformUtil transformUtil;


    //Password encoder for better security
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public UserRes saveUser(UserReq user){
        user.setPassword(encoder.encode(user.getPassword()));
        User newUser = transformUtil.transformToUser(user);
        User savedUser = userRepo.save(newUser);
        return transformUtil.transformUserRes(savedUser);
    }

    public List<User> getAllUsers(){
        return userRepo.findAll();
    }

    public UserRes getUserById(Long id){
        return transformUtil.transformUserRes(userRepo.findById(id).get());
    }

    public void deleteUserById(Long id){
        userRepo.deleteById(id);
    }

    public String verify(User user) {
        Authentication authentication =
                authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        if (authentication.isAuthenticated()){
            HashMap<String, Object> role = new HashMap<>();
            role.put("role", user.getRole().toString());
            return jwtService.generateToken(role, user);
        }else {
            return "Unable to find user or password";
        }
    }

    public User getUserByUsername(String username){
        return userRepo.findByUsername(username);
    }

    public UserRes updateUser(Long id, UserReq userRequest){
        User updatedUser = userRepo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        if (updatedUser != null) {
            updatedUser.setUsername(userRequest.getUsername());
            updatedUser.setPassword(encoder.encode(userRequest.getPassword()));
            userRepo.save(updatedUser);
            return transformUtil.transformUserRes(updatedUser);
        }
        return null;
    }
}
