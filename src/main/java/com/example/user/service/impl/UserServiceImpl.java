package com.example.user.service.impl;

import static com.example.user.utils.Constants.STATUS_ERROR;
import static com.example.user.utils.Constants.MSG_EMAIL_EXIST;

import static com.example.user.utils.Constants.ID;
import static com.example.user.utils.Constants.CREATED;
import static com.example.user.utils.Constants.MODIFIED;
import static com.example.user.utils.Constants.LAST_LOGIN;
import static com.example.user.utils.Constants.TOKEN;
import static com.example.user.utils.Constants.ISACTIVE;

import static com.example.user.utils.Constants.EMAIL_PATTERN;
import static com.example.user.utils.Constants.MSG_EMAIL_INVALID;
import static com.example.user.utils.Constants.MSG_PASSWORD_INVALID;

import com.example.user.models.entity.Phone;
import com.example.user.models.entity.User;
import com.example.user.models.request.PhoneRequest;
import com.example.user.models.request.UserRequest;
import com.example.user.repository.UserRepository;
import com.example.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.regex.Pattern;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Value("${password.regex}")
    private String password_regex;

    @Override
    public ResponseEntity<Map<String, Object>> save(UserRequest userRequest) {
        if (!isValidUserRequest(userRequest).isEmpty()) {
            return ResponseEntity.badRequest().body(isValidUserRequest(userRequest));
        } else {
            return responseUserCreated(userRepository.save(builderUser(userRequest)));
        }
    }

    @Override
    public boolean isEmailAlreadyExists(String email)  {
        return userRepository.existsByEmail(email);
    }

    private  Map<String, Object> isValidUserRequest(UserRequest request){
        Map<String, Object> response = new LinkedHashMap<>();
        if (!isValidPassword(request.getPassword())) {
            response.put(STATUS_ERROR, MSG_PASSWORD_INVALID);
        }
        if (!isValidEmail(request.getEmail())) {
            response.put(STATUS_ERROR, MSG_EMAIL_INVALID);
        }
        if (isEmailAlreadyExists(request.getEmail())) {
            response.put(STATUS_ERROR, MSG_EMAIL_EXIST);
        }
        return response;
    }

    private List<Phone> builderPhone(List<PhoneRequest> lstPhone, User user){
        List<Phone> phones = new ArrayList<>();
        if (lstPhone!= null || !lstPhone.isEmpty()) {
            for (PhoneRequest request : lstPhone) {
                Phone phone = new Phone();
                phone.setNumber(request.getNumber());
                phone.setCity(request.getCitycode());
                phone.setCountryCode(request.getContrycode());
                phone.setUser(user);
                phones.add(phone);
            }
            user.setPhones(phones);
        }
        return phones;
    }

    private User builderUser(UserRequest userRequest){
        User user = new User();
        user.setName(userRequest.getName());
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        user.setPhones(user.getPhones());
        user.setDateCreated(LocalDate.now());
        user.setDateModified(LocalDate.now());
        user.setLastLogin(LocalDate.now());
        user.setToken(UUID.randomUUID().toString());
        user.setInactive(true);
        if (userRequest.getPhones() != null || !userRequest.getPhones().isEmpty()) {
            user.setPhones(builderPhone(userRequest.getPhones(), user));
        }else {
            user.setPhones(null);
        }
        return user;
    }

    private ResponseEntity<Map<String, Object>> responseUserCreated(User resUser){
        Map<String, Object> response = new LinkedHashMap<>();
        response.put(ID, resUser.getId());
        response.put(CREATED, resUser.getDateCreated());
        response.put(MODIFIED, resUser.getDateModified());
        response.put(LAST_LOGIN, resUser.getLastLogin());
        response.put(TOKEN, resUser.getToken());
        response.put(ISACTIVE, resUser.getInactive());
        return ResponseEntity.ok(response);
    }

    private boolean isValidEmail(String email) {
        return EMAIL_PATTERN.matcher(email).matches();
    }

    private boolean isValidPassword(String password) {
        return Pattern.matches(password_regex, password);
    }
}
