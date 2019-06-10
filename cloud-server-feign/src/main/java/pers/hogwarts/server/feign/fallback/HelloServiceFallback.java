package pers.hogwarts.server.feign.fallback;


import org.springframework.stereotype.Component;
import pers.hogwarts.server.feign.client.HelloServiceClient;

@Component
public class HelloServiceFallback implements HelloServiceClient {

    @Override
    public String hello(String name) {
        return "sorry " + name;
    }
}
