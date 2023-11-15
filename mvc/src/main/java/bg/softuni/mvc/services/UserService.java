package bg.softuni.mvc.services;

import bg.softuni.mvc.dtos.UserRegisterDTO;

public interface UserService {
    boolean register(UserRegisterDTO registerDTO);
}