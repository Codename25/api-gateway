package start.up.apigateway.filter;

import io.micrometer.common.util.StringUtils;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import start.up.apigateway.exception_handling.AuthException;
import start.up.apigateway.service.JwtService;
import start.up.apigateway.service.JwtTokenService;

import static org.springframework.http.server.reactive.ServerHttpRequestDecorator.getNativeRequest;

@Component
@RequiredArgsConstructor
public class AuthFilter implements GatewayFilter {
    private final JwtService jwtService;
    private final JwtTokenService jwtTokenService;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain filterChain) {
        // Extract HttpServletRequest from ServerHttpRequest
        HttpServletRequest request = getNativeRequest(exchange.getRequest());
        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        final String jwt;
        final String userEmail;

        if (StringUtils.isEmpty(authHeader) || !authHeader.startsWith("Bearer_")) {
            throw new AuthException("User is not authenticated");
        }

        jwt = authHeader.substring(7);
        userEmail = jwtService.extractUserName(jwt);
        if (StringUtils.isNotEmpty(userEmail)) {
            // check if jwt is valid (user didn't logout)
            if (jwtTokenService.isTokenExpired(jwt)) {
                throw new AuthException("Token has already expired");
            }
        }
        return filterChain.filter(exchange);
    }
}
