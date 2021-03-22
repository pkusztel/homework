package com.silenteight.homework;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

@SpringBootApplication
public class HomeworkApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomeworkApplication.class, args);
	}

	@Bean
	@Scope("prototype")
	InputStream maleStream() throws IOException {
		return new ClassPathResource("m.txt").getInputStream();
	}

	@Bean
	@Scope("prototype")
	InputStream femaleStream() throws IOException {
		return new ClassPathResource("f.txt").getInputStream();
	}

	@Bean
	@Scope("prototype")
	Iterator<String> maleFileIterator(@Autowired @Qualifier("maleStream") InputStream maleStream) throws IOException {
		return IOUtils.lineIterator(maleStream, "UTF-8");
	}

	@Bean
	@Scope("prototype")
	Iterator<String> femaleFileIterator(@Autowired @Qualifier("femaleStream") InputStream femaleStream)
			throws IOException {
		return IOUtils.lineIterator(femaleStream, "UTF-8");
	}


}
