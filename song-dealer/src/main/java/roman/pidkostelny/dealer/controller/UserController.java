package roman.pidkostelny.dealer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import roman.pidkostelny.dealer.dto.request.UserRequest;
import roman.pidkostelny.dealer.service.UserService;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;


@CrossOrigin
@RestController

public class UserController {
    @Autowired
    private UserService userService;

    @NotBlank
    @PostMapping("/public/register")
    public String saveUser(@Valid @RequestBody UserRequest userRequest) throws Exception {
        return userService.save(userRequest);
    }

    @NotBlank
    @PostMapping("/public/login")
    public String login(@Valid @RequestBody UserRequest userRequest) throws Exception {
        return userService.findOneByRequest(userRequest);
    }
}