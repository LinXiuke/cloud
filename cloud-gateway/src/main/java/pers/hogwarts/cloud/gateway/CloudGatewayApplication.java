package pers.hogwarts.cloud.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class CloudGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudGatewayApplication.class, args);
    }


//    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {

        String httpUri = "http://httpbin.org:80";

        return builder.routes()
                .route(predicateSpec -> predicateSpec
                        .path("/get")
                        .filters(f -> f.addRequestHeader("Hello", "World"))
                        .uri(httpUri))
                .route(predicateSpec -> predicateSpec
                        .host("*hystrix.com")
                        .filters(f -> f
                                .hystrix(config -> config
                                        .setName("myCMD")
                                        .setFallbackUri("forward:/fallback")))
                        .uri(httpUri))
                .build();
    }


    @RequestMapping("/fallback")
    public Mono<String> fallback() {
        return Mono.just("fallback");
    }
}
