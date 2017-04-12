package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // same as @Configuration @EnableAutoConfiguration @ComponentScan
public class Application {

	public static void main(String[] args) {


	/*
	* Plan:
	* 1. Test Rest
	* 2. Where is session?
	* 3. Test all types of beans
	* 4. Test hot swap + hot deploy
		1. Enable Automake from the compiler
			PRESS: CTRL + SHIFT + A
			TYPE: make project automatically
			PRESS: Enter
			Enable Make Project automatically feature

		2. Enable Automake when the application is running
			PRESS: CTRL + SHIFT + A
			TYPE: Registry
			Find the key compiler.automake.allow.when.app.running and enable it

		3. VM Options:  -javaagent:/home/demo/SpringLoader/springloaded-1.2.5.RELEASE.jar -noverify
	*/


		/*
		Default Spring Devtools properties:
			https://docs.spring.io/spring-boot/docs/current/reference/html/common-application-properties.html
		*/

//		System.setProperty("spring.devtools.livereload.enabled", "true");
//		System.setProperty("spring.devtools.restart.enabled", "true");
//		System.setProperty("spring.devtools.restart.additional-paths", "src");
//		System.setProperty("spring.devtools.restart.exclude", "src/main/resources");
		System.setProperty("server.session.timeout", "3");
		SpringApplication.run(Application.class, args);
	}
}
