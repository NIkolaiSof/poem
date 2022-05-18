package com.poema.keywords.service;


import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class Poem {

	
	private static ArrayList<String> poemList = new ArrayList<>();
	
	
	private static ArrayList<String> adjetive = new ArrayList<>();
	
	private static ArrayList<String> noun = new ArrayList<>();
	
	private static ArrayList<String> verb = new ArrayList<>();
	
	private static ArrayList<String> pronoun = new ArrayList<>();
	
	
	private static ArrayList<String> preposition = new ArrayList<>();
	
	private String poem="";
	
	static{
		poemList.add("NOUN");
		poemList.add("PREPOSITION");
		poemList.add("PRONOUN");
		poemList.add("LINEBREAK");
		
		adjetive.add("black");
		adjetive.add("white");
		adjetive.add("dark");
		adjetive.add("light");
		adjetive.add("bright");
		adjetive.add("murky");
		adjetive.add("muddy");
		adjetive.add("clear");
		adjetive.add("NOUN");
		adjetive.add("ADJECTIVE");
		adjetive.add("END");
		
		noun.add("heart");
		noun.add("sun");
		noun.add("moon");
		noun.add("thunder");
		noun.add("fire");
		noun.add("time");
		noun.add("wind");
		noun.add("sea");
		noun.add("river");
		noun.add("flavor");
		noun.add("wave");
		noun.add("willow");
		noun.add("rain");
		noun.add("tree");
		noun.add("flowe");
		noun.add("VERB");
		noun.add("PREPOSITION");
		noun.add("END");
	
		
		verb.add("runs");
		verb.add("walks");
		verb.add("stands");
		verb.add("climbs");
		verb.add("crawls");
		verb.add("flows");
		verb.add("flies");
		verb.add("transcends");
		verb.add("ascends");
		verb.add("descends");
		verb.add("sinks");
		verb.add("PREPOSITION");
		verb.add("PRONOUN");
		verb.add("END");
		
		pronoun.add("my");
		pronoun.add("your");
		pronoun.add("his");
		pronoun.add("her");
		pronoun.add("NOUN");
		pronoun.add("ADJECTIVE");
		
		
		preposition.add("above");
		preposition.add("across");
		preposition.add("against");
		preposition.add("along");
		preposition.add("among");
		preposition.add("around");
		preposition.add("before");
		preposition.add("behind");
		preposition.add("beneath");
		preposition.add("beside");
		preposition.add("between");
		preposition.add("beyond");
		preposition.add("during");
		preposition.add("inside");
		preposition.add("onto");
		preposition.add("outside");
		preposition.add("under");
		preposition.add("underneath");
		preposition.add("upon");
		preposition.add("with");
		preposition.add("without");
		preposition.add("through");
		preposition.add("NOUN");
		preposition.add("PRONOUN");
		preposition.add("ADJECTIVE");
		
		

		
	}



	public String createPoem() throws NoSuchAlgorithmException {
		
				
	    for(int i = 0; i < 5; i++){
	    	poemList.stream().forEach(c -> {
				try {
					executionPoem(c);
				} catch (NoSuchAlgorithmException e) {
					
					e.printStackTrace();
				}
			});

        }
		
	    System.out.println(poem);
		return null;
	}
	
	public String randomString(List<String> list ) throws NoSuchAlgorithmException
	{


		 Random rand = SecureRandom.getInstanceStrong();
		Optional<String> lineToExecute=list.stream().skip(rand.nextInt(list.size())).findFirst();
		return lineToExecute.orElse("null");
	}
	
	public void executionPoem(String caseExecution) throws NoSuchAlgorithmException {
		
		switch(caseExecution)
		{

		   case "PRONOUN" :
			   executionPoem(randomString(pronoun));
		      break; 
		   
		   case "NOUN" :
			   executionPoem(randomString(noun));
		      break;
		      
		   case "PREPOSITION" :
			   executionPoem(randomString(preposition));
		      break;
		   
		   case "VERB" :
			   executionPoem(randomString(verb));
		      break;
		   
		   case "ADJECTIVE" :
			   executionPoem(randomString(adjetive));
		      break;
		      
		   case "END" :
		      break;
		      
		   case "LINEBREAK" :
			   pritn("\n");
		      break; 


		   default : 
			   pritn(caseExecution);
		}
	}
	
	public void pritn(String wordPrint) {
		poem=poem+" "+wordPrint;
		
	}
	
	
}
