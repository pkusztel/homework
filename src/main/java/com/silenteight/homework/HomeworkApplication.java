package com.silenteight.homework;

import org.apache.commons.io.IOUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.Iterator;

@SpringBootApplication
public class HomeworkApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomeworkApplication.class, args);
	}

	@Bean
	@Scope("prototype")
	Iterator<String> maleFileIterator() throws IOException {
		return IOUtils.lineIterator(new ClassPathResource("m.txt").getInputStream(), "UTF-8");
	}

	@Bean
	@Scope("prototype")
	Iterator<String> femaleFileIterator() throws IOException {
		return IOUtils.lineIterator(new ClassPathResource("f.txt").getInputStream(), "UTF-8");
	}


}
