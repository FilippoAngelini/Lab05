package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Model {
	
	
	public void recursive(List<Character> caratteri, Set<String> anagrammi,String parziale,int lunghezza){
		
		

		for (char c : caratteri) {
			
			List<Character> temp = new LinkedList<Character>(caratteri);
			parziale+=c;
			
			if(parziale.length()==lunghezza){
			anagrammi.add(parziale);
			parziale="";
			}
			if(caratteri.size()==1)
				break;
			int indice = caratteri.indexOf(c);
			temp.remove(indice);
			//delego la ricerca al livello successivo
			recursive(temp,anagrammi,parziale,lunghezza);
			parziale=parziale.substring(0, parziale.length()-1);
			//caratteri.add(indice, c);
			}
		
	}
			
	
	public Set<String> calcolaAnagrammi(String parola) {

		char[] caratteri = parola.toCharArray();
		LinkedList<Character> car = new LinkedList<Character>();
		for(char c : caratteri)
			car.add(c);
		String parziale="";
		Set<String> anagrammi = new HashSet<String>();
		recursive(car,anagrammi,parziale,parola.length());
		return anagrammi;
	}

}
