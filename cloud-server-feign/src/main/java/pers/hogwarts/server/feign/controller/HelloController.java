package pers.hogwarts.server.feign.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pers.hogwarts.server.feign.client.HelloServiceClient;

@RestController
public class HelloController {

    @Autowired
    private HelloServiceClient helloService;


    @RequestMapping(value = "/hello")
    public String hi(@RequestParam String name){
        return helloService.hello(name);
    }
}
