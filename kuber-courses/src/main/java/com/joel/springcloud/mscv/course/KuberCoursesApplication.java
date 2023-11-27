package com.joel.springcloud.mscv.course;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class KuberCoursesApplication {

	public static void main(String[] args) {
		SpringApplication.run(KuberCoursesApplication.class, args);
	}

}
