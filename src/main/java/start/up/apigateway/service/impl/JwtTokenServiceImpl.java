package start.up.apigateway.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import start.up.apigateway.model.JwtToken;
import start.up.apigateway.repository.JwtTokenRepository;
import start.up.apigateway.service.JwtTokenService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JwtTokenServiceImpl implements JwtTokenService {
    private final JwtTokenRepository jwtTokenRepository;

    @Override
    public boolean isTokenExpired(String token) {
        Optional<JwtToken> jwt = jwtTokenRepository.findByToken(token);
        return jwt.map(JwtToken::isExpired).orElse(false);
    }
}
