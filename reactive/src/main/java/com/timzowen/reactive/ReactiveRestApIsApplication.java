package com.timzowen.reactive;

import com.timzowen.reactive.entity.Student;
import com.timzowen.reactive.service.StudentService;
import com.timzowen.reactive.service.impl.StudentServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ReactiveRestApIsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveRestApIsApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentService studentService){
		return args -> {
			for (int i=0; i<100; i++){
				studentService.saveStudent(
						Student.builder()
								.firstName("Timz")
								.lastName("Owen")
								.age(i)
								.build()
				).subscribe();
			}
		};
	}

}
