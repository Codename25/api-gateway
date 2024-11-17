package start.up.apigateway.service;

import start.up.apigateway.model.User;

public interface UserService {
    User findByEmail(String email);
}
