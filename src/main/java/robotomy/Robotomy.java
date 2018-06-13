package robotomy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:application.yml")
public class Robotomy {

  public static void main(String[] args) {
    SpringApplication.run(Robotomy.class, args);
  }
}
