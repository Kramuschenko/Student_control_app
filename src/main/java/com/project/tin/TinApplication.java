package com.project.tin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
@RequestMapping(value = "", produces = {"application/json", "text/xml"})
public class TinApplication {

	public static void main(String[] args) {
		SpringApplication.run(TinApplication.class, args);
	}

}
