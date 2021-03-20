package com.silenteight.homework;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
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
		File f = new ClassPathResource("m.txt").getFile();
		LineIterator lineIterator = FileUtils.lineIterator(f, "UTF-8");
		return lineIterator;
	}

	@Bean
	@Scope("prototype")
	Iterator<String> femaleFileIterator() throws IOException {
		File f = new ClassPathResource("f.txt").getFile();
		LineIterator lineIterator = FileUtils.lineIterator(f, "UTF-8");
		return lineIterator;
	}


}
