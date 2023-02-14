package com.timzowen.hospital.crud;

import com.timzowen.hospital.crud.entity.Doctor;
import com.timzowen.hospital.crud.repository.DoctorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HospitalCrudApplication implements CommandLineRunner {
	@Autowired
	private DoctorsRepository doctorsRepository;

	public static void main(String[] args) {
		SpringApplication.run(HospitalCrudApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

		Doctor doctors = new Doctor();
		doctors.setFirstName("Timz");
		doctors.setEmail("timz@google.com");
		doctors.setLastName("Owen");
		doctorsRepository.save(doctors);

		Doctor doctors1 = new Doctor();
		doctors1.setFirstName("james");
		doctors1.setEmail("jemo@google.com");
		doctors1.setLastName("mwangi");
		doctorsRepository.save(doctors1);

		Doctor doc2 = new Doctor();
		doc2.setFirstName("Philomena");
		doc2.setEmail("philo@google.com");
		doc2.setLastName("Mwilu");
		doctorsRepository.save(doc2);



	}
}
