package ${package};


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SimpleAxonApplication {
    public static void main(String[] args) {
        SpringApplication.run(SimpleAxonApplication.class, args);
    }
}
