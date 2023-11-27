package org.joel.springcloud.msvc.users;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class KuberUsersApplication {

	public static void main(String[] args) {
		SpringApplication.run(KuberUsersApplication.class, args);
	}

}
