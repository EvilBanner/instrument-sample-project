package initializer;

import config.Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author Patrik Procházka
 */
@SpringBootApplication
@EnableWebMvc
@Import(Config.class)
public class WebbAppRunner extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(WebbAppRunner.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(WebbAppRunner.class, args);
    }
}
