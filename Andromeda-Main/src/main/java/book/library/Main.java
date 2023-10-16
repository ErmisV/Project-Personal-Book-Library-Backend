package book.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"book.library.*"})
@EntityScan(basePackages = {"book.library.*"})
@EnableJpaRepositories(basePackages = {"book.library.*"})
public class Main {

        public static void main(String[] args) {SpringApplication.run(Main.class, args);}

}
