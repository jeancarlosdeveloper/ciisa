package cl.ciisa.clase1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class Clase1Application {

	public static void main(String[] args) {
		SpringApplication.run(Clase1Application.class, args);
	}

}
