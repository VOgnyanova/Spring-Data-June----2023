package bg.softuni.gamestoremapping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;



@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })

public class gamestoremapping {

	public static void main(String[] args) {
		SpringApplication.run(gamestoremapping.class, args);
	}

}