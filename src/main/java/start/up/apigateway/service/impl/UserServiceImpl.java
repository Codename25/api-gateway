package start.up.apigateway.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import start.up.apigateway.model.User;
import start.up.apigateway.repository.UserRepository;
import start.up.apigateway.service.UserService;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> {
            throw new RuntimeException("No entity found exception");
        });
    }
}
