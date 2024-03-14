package crisci.caterina.goodstream.service;

import crisci.caterina.goodstream.DTO.UserDTO;
import crisci.caterina.goodstream.exceptions.NotFoundException;
import crisci.caterina.goodstream.models.User;
import crisci.caterina.goodstream.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public User saveUser(UserDTO userDTO) {
        return userRepository.save(User.fromDTO(userDTO));
    }

    public User getById(UUID Id) {
        return userRepository.findById(Id).orElseThrow();
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new NotFoundException("Email" + email + "not found"));
    }

    public void delete(UUID userId) {
        userRepository.deleteById(userId);
    }


}
