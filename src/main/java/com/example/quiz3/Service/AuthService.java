package com.example.quiz3.Service;

import com.example.quiz3.Api.ApiException;
import com.example.quiz3.Model.User;
import com.example.quiz3.Repository.AuthRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthService {

    private AuthRepository authRepository;

    public List<User> getAllUsers() {
        return authRepository.findAll();
    }

    public void register(User user) {


    }

    public void delete(User user) {
        User user1=authRepository.findUserById(user.getId());
        if(user1==null) {
            throw new ApiException("User not found");
        }
        authRepository.delete(user1);
    }
}
