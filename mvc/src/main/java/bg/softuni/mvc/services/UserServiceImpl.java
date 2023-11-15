package bg.softuni.mvc.services;

import bg.softuni.mvc.dtos.UserRegisterDTO;
import bg.softuni.mvc.entities.User;
import bg.softuni.mvc.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean register(UserRegisterDTO registerDTO) {
        ModelMapper mapper = new ModelMapper();
        User user = mapper.map(registerDTO, User.class);

        boolean emailInUse = userRepository.existsByEmail(registerDTO.getEmail());

        if (emailInUse) {
            return false;
        }

        userRepository.save(user);
        return true;
    }
}