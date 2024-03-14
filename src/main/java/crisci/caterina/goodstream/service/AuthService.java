package crisci.caterina.goodstream.service;

import crisci.caterina.goodstream.DTO.UserDTO;
import crisci.caterina.goodstream.exceptions.BadRequestException;
import crisci.caterina.goodstream.exceptions.UnauthorizedException;
import crisci.caterina.goodstream.models.User;
import crisci.caterina.goodstream.repository.UserRepository;
import crisci.caterina.goodstream.security.JWTTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserService userService;

    @Autowired
    private JWTTools jwtTools;

    @Autowired
    private PasswordEncoder bcrypt;
    @Autowired
    private UserRepository userRepository;

    public String authUserAndGenerateToken(UserDTO body) throws UnauthorizedException {
        User user = userService.findByEmail(body.email());
        if (bcrypt.matches(body.password(), user.getPassword())) {
            return jwtTools.createToken(user);
        } else {
            throw new UnauthorizedException("Incorrect credentials");
        }
    }

    public User save(UserDTO user) {
        userRepository.findByEmail(user.email()).ifPresent(newUser ->{
            throw new BadRequestException("The email is already in use");
        });
        String avatar =  "https://ui-avatars.com/api/?name=" + user.fullName();
        User newUser = User.fromDTO(user);

        return userRepository.save(newUser);
    }

}
