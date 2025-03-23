package org.adrian;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;
@org.springframework.boot.autoconfigure.SpringBootApplication

@ComponentScan({"org.adrian"})
public class Main {
    public static void main(String[] args) {

        SpringApplication.run(Main.class, args);
    }
}