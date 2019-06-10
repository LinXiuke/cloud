package pers.hogwarts.service.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class CloudServiceZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudServiceZuulApplication.class, args);
    }

}
