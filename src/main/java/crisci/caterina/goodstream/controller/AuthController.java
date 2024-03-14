package crisci.caterina.goodstream.controller;

import crisci.caterina.goodstream.DTO.LoginDTO;
import crisci.caterina.goodstream.DTO.UserDTO;
import crisci.caterina.goodstream.models.User;
import crisci.caterina.goodstream.service.AuthService;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "htto://localhost:4200")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public LoginDTO login(@RequestBody UserDTO body) {
        return new LoginDTO(authService.authUserAndGenerateToken(body));
    }

    @PostMapping("/register")
    public User register(@RequestBody @Validated UserDTO body, BindingResult validation) throws BadRequestException { if (validation.hasErrors()) {
        throw new BadRequestException(String.valueOf(validation.getAllErrors()));
    }

    return this.authService.save(body);
    }


}
