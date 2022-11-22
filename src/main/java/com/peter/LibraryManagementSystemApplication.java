package com.peter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/*https://qiita.com/hhujk5/items/a35fab16614164c99718
 * a successful example
 * spring boot+mybatis+mysql+thymeleaf
 * 
 * */

@SpringBootApplication
@ComponentScan("com.peter")
public class LibraryManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryManagementSystemApplication.class, args);
	}

}
