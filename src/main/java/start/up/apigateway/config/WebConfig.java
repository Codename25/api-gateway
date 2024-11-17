package start.up.apigateway.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")
//                .allowedOrigins("http://localhost:3000")
//                .allowedMethods("GET", "POST", "PUT", "OPTIONS")
//                .allowCredentials(true)
//                .exposedHeaders("Access-Control-Allow-Origin", "Authorization")
//                .allowedHeaders("Json-View","X-PINGOTHER","Content-Type","X-Requested-With","Accept","Origin",
//                        "Access-Control-Request-Method","Access-Control-Request-Headers","Authorization", "Access-Control-Allow-Origin");
//    }
}
