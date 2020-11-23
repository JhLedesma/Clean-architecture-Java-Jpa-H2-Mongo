package application.run;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableJpaRepositories("repository.sql")
@EnableMongoRepositories("repository.document")
@EntityScan("repository")
public class SpringRun {

	public static void main(String[] args) {
		SpringApplication.run(SpringRun.class, args);
	}
}




