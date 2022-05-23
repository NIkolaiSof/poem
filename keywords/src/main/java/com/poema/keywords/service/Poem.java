package com.poema.keywords.service;


import java.io.*;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.*;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class Poem {

	private static ArrayList<String> line = new ArrayList<>();
	private static ArrayList<String> poemList = new ArrayList<>();
	
	
	private static ArrayList<String> adjetive = new ArrayList<>();
	
	private static ArrayList<String> noun = new ArrayList<>();
	
	private static ArrayList<String> verb = new ArrayList<>();
	
	private static ArrayList<String> pronoun = new ArrayList<>();
	
	
	private static ArrayList<String> preposition = new ArrayList<>();

	private static  HashMap<String, String> hash_map = new HashMap<String, String>();
	
	private String poem=null;


	final Logger LOGGER = LoggerFactory.getLogger(getClass());
	
	static{


		try(BufferedReader br = new BufferedReader(new FileReader("/home/nikolai/Documentos/proyectos/poema/poem/keywords/src/main/resources/lectura.txt"))) {
			String line = br.readLine();

			while (line != null) {
				String[] parts = line.split(":");
				hash_map.put(parts[0],parts[1]);
				line = br.readLine();
			}

		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		line= new ArrayList<String>(Arrays.asList(hash_map.get("POEM").split("(\\|)|(\\s+)")));
		poemList= new ArrayList<String>(Arrays.asList(hash_map.get("LINE").split("(\\|)|(\\s+)")));
		adjetive= new ArrayList<String>(Arrays.asList(hash_map.get("ADJECTIVE").split("(\\|)|(\\s+)")));
		noun= new ArrayList<String>(Arrays.asList(hash_map.get("NOUN").split("(\\|)|(\\s+)")));
		verb= new ArrayList<String>(Arrays.asList(hash_map.get("VERB").split("(\\|)|(\\s+)")));
		pronoun= new ArrayList<String>(Arrays.asList(hash_map.get("PRONOUN").split("(\\|)|(\\s+)")));
		preposition= new ArrayList<String>(Arrays.asList(hash_map.get("PREPOSITION").split("(\\|)|(\\s+)")));

	}



	public String createPoem() throws NoSuchAlgorithmException {
		
				poem="";

			for(String str : line){
	    	poemList.stream().forEach(c -> {
				try {
					executionPoem(c);
				} catch (NoSuchAlgorithmException e) {
					
					e.printStackTrace();
				}
			});

        }
		
	    //System.out.println(poem);
		return poem;
	}
	
	public String randomString(List<String> list ) throws NoSuchAlgorithmException
	{

		List<String>words=list.stream().filter(x -> !x.contains("<")).filter(x ->  !x.contains("$")).collect(Collectors.toList());

		List<String> listWords=list.stream().filter(x -> x.contains("<") || x.contains("$")).collect(Collectors.toList());

		Random rand = SecureRandom.getInstanceStrong();

		Optional<String> lineToExecute=words.stream()
				.skip(rand.nextInt(words.size()))
				.findFirst();
		pritn(lineToExecute.orElse(""));

		lineToExecute=listWords.stream()
				.skip(rand.nextInt(listWords.size()))
				.findFirst();

		return lineToExecute.orElse("");
	}
	
	public void executionPoem(String caseExecution) throws NoSuchAlgorithmException {


		switch(caseExecution)
		{

		   case "<PRONOUN>" :
			   executionPoem(randomString(pronoun.stream().collect(Collectors.toList())));
			   //executionPoem(randomString(pronoun.stream().filter(x -> !x.contains("<")).collect(Collectors.toList())));
			   //executionPoem(randomString(pronoun.stream().filter(x -> x.contains("<") || x.contains("$")).collect(Collectors.toList())));
		      break;

		   case "<NOUN>" :
			   executionPoem(randomString(noun.stream().collect(Collectors.toList())));
			   //executionPoem(randomString(noun.stream().filter(x -> !x.contains("<")).collect(Collectors.toList())));
			   //executionPoem(randomString(noun.stream().filter(x -> x.contains("<") || x.contains("$")).collect(Collectors.toList())));
		      break;

		   case "<PREPOSITION>" :
			   executionPoem(randomString(preposition.stream().collect(Collectors.toList())));
			   //executionPoem(randomString(preposition.stream().filter(x -> !x.contains("<")).collect(Collectors.toList())));
			   //executionPoem(randomString(preposition.stream().filter(x -> x.contains("<") || x.contains("$")).collect(Collectors.toList())));
		      break;

		   case "<VERB>" :
			   executionPoem(randomString(verb.stream().collect(Collectors.toList())));
			   //executionPoem(randomString(verb.stream().filter(x -> !x.contains("<")).collect(Collectors.toList())));
			   //executionPoem(randomString(verb.stream().filter(x -> x.contains("<") || x.contains("$")).collect(Collectors.toList())));
		      break;

		   case "<ADJECTIVE>" :
			   //executionPoem(randomString(adjetive.stream().filter(x -> !x.contains("<")).collect(Collectors.toList())));
			   //executionPoem(randomString(adjetive.stream().filter(x -> !x.contains("<")).collect(Collectors.toList())));
			   executionPoem(randomString(adjetive.stream().collect(Collectors.toList())));
		      break;

		   case "$END" :
		      break;
		      
		   case "$LINEBREAK" :
			   pritn("\n");
		      break;


		   default :
			   pritn("");
		}
	}
	
	public void pritn(String wordPrint) {
		poem=poem+" "+wordPrint;
		
	}
	
	
}
