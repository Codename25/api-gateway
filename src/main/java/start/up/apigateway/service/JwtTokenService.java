package start.up.apigateway.service;

public interface JwtTokenService {
    boolean isTokenExpired(String token);
}
