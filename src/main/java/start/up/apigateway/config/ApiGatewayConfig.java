package start.up.apigateway.config;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import start.up.apigateway.filter.AuthFilter;

@Configuration
@RequiredArgsConstructor
public class ApiGatewayConfig {
    private final AuthFilter authFilter;

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/api/images/**")
                        .filters(f -> f.filter(authFilter))
                        .uri("http://auth-service:8082"))
                .route(r -> r.path("/api/auth/**")
                        .uri("http://auth-service:8082"))
                .route(r -> r.path("/oauth2/**")
                        .uri("http://auth-service:8082"))
                .route(r -> r.path("/login/oauth2/**")
                        .uri("http://auth-service:8082"))
                .route(r -> r.path("/api/users/**")
                        .filters(f -> f.filter(authFilter))
                        .uri("http://auth-service:8082"))
                .route(r -> r.path("/ai/**")
                        .filters(f -> f.filter(authFilter))
                        .uri("http://ai-queue:8085"))
                .route(r -> r.path("/api/email/**")
                        .uri("http://email-service:8083"))
                .build();
    }
}
