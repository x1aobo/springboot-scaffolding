#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author cjunl
 */
@SpringBootApplication
@ComponentScan("${package}.${parentArtifactId}")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
