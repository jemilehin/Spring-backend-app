package temi.dev.demobackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class DemobackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemobackendApplication.class, args);
	}

}
