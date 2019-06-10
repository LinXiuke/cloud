package pers.hogwarts.server.ribbon.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pers.hogwarts.server.ribbon.service.HelloService;

@RestController
public class HiController {

    @Autowired
    private HelloService helloService;


    @RequestMapping(value = "/hi")
    public String hi(@RequestParam String name){
        return helloService.hi(name);
    }
}
