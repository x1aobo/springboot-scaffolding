package it.pkg.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author cjunl
 */
@SpringBootApplication
@ComponentScan("it.pkg.basic")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
