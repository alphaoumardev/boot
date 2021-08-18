package com.alpha.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class BootApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(BootApplication.class, args);
	}
	@GetMapping(value="/diallo")
	public List<String> hello()
	{
		return List.of("Hello here Diallo","Json");
	}

}
