package pers.hogwarts.server.feign.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pers.hogwarts.server.feign.fallback.HelloServiceFallback;

@FeignClient(value = "service-hello", fallback = HelloServiceFallback.class)
public interface HelloServiceClient {

    @GetMapping("/hello")
    String hello(@RequestParam("name") String name);
}
