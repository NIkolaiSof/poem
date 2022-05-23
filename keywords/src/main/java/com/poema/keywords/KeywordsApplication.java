package com.poema.keywords;

import java.security.NoSuchAlgorithmException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.poema.keywords.service.Poem;

@SpringBootApplication
public class KeywordsApplication {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		SpringApplication.run(KeywordsApplication.class, args);
		
		
			}

}
