package roman.pidkostelny.dealer.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import roman.pidkostelny.dealer.Security.tokenUtils.TokenTool;
import roman.pidkostelny.dealer.dto.request.UserRequest;
import roman.pidkostelny.dealer.entity.Role;
import roman.pidkostelny.dealer.entity.User;
import roman.pidkostelny.dealer.exception.WrongInp;
import roman.pidkostelny.dealer.repository.UserRepository;


@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private TokenTool tokenTool;


    public String save(UserRequest request) throws Exception {
        if (userRepository.findByLoginEquals(request.getLogin()).isPresent()) {
            throw new Exception("Credentials are busy. Please, try one more time " +
                    "with other login");
        }
        User user = new User();
        user.setLogin(request.getLogin());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(Role.USER);

        user = userRepository.saveAndFlush(user);

        return tokenTool.createToken(user.getLogin(), user.getRole().name());
    }


    public String findOneByRequest(UserRequest userRequest) throws WrongInp {
        User user = userRepository.findByLoginEquals(userRequest.getLogin()).orElseThrow(() -> new WrongInp("User with login " + userRequest.getLogin() + " not exists"));

        if (passwordEncoder.matches(userRequest.getPassword(), user.getPassword())) {
            return tokenTool.createToken(user.getLogin(), user.getRole().name());
        }

        throw new IllegalArgumentException("Wrong login or password");
    }
}
