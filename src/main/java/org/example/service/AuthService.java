package org.example.service;

import org.example.model.LoginDto;

public interface AuthService {
    String login(LoginDto loginDto);
}
