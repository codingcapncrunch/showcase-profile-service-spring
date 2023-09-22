package com.org.myapp;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableEncryptableProperties
@EnableCaching
public class ShowcaseApp {

	public static void main(String[] args) {
		SpringApplication.run(ShowcaseApp.class, args);
	}

}
