package com.example.user.service;

import com.example.user.models.entity.User;
import com.example.user.models.request.UserRequest;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface UserService {

    ResponseEntity<Map<String, Object>> save(UserRequest user);

    boolean isEmailAlreadyExists(String email);
}
