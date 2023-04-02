package com.vntechies.k8sspringbootseries.students;

import com.vntechies.k8sspringbootseries.students.configs.AppConfigs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentsApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentsApplication.class, args);
		System.out.println(new AppConfigs().toString());
	}

}
