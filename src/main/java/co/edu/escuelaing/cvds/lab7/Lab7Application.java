package co.edu.escuelaing.cvds.lab7;

import co.edu.escuelaing.cvds.lab7.model.Configuration;
import co.edu.escuelaing.cvds.lab7.model.Employee;
import co.edu.escuelaing.cvds.lab7.model.User;
import co.edu.escuelaing.cvds.lab7.model.UserRole;
import co.edu.escuelaing.cvds.lab7.repository.UserRepository;
import co.edu.escuelaing.cvds.lab7.service.ConfigurationService;
import co.edu.escuelaing.cvds.lab7.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@SpringBootApplication
@Slf4j
public class Lab7Application {
	private final ConfigurationService configurationService;
	private final EmployeeService employeeService;

	private final UserRepository userRepository;

	@Autowired
	public Lab7Application(
			ConfigurationService configurationService,
			UserRepository userRepository, EmployeeService employeeService
	) {
		this.configurationService = configurationService;
		this.userRepository = userRepository;
		this.employeeService = employeeService;
	}

	public static void main(String[] args) {
		SpringApplication.run(Lab7Application.class, args);
	}

	@Bean
	public CommandLineRunner run() {
		return (args) -> {
			employeeService.addEmployee(new Employee("1","Camilo","Castaño","SCRUM MASTER",10000000));
			employeeService.addEmployee(new Employee("2","Josue","Hernandez","Back-end",4000000));
			employeeService.addEmployee(new Employee("3","Saray","Gonzales","Front-End",5000000.50));
			/*
			log.info("\nGetting all configurations....");
			configurationService.getAllConfigurations().forEach(configuration -> System.out.println(configuration));

			log.info("\nAdding admin@site.org user with Password: admin");
			userRepository.save(new User("admin@site.org", "admin", Arrays.asList(UserRole.ADMINISTRADOR, UserRole.CLIENTE)));
		*/
		};
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
