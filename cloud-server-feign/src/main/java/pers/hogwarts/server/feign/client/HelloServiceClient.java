package pers.hogwarts.server.feign.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("service-hello")
public interface HelloServiceClient {

    @GetMapping("/hello")
    String hello(@RequestParam("name") String name);
}
