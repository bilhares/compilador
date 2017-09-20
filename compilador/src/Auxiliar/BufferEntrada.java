package Auxiliar;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
public class BufferEntrada {
	
	

	FileReader arq;
	BufferedReader lerArq;
	
	private ArrayList<Character> buffer;
	private Integer init, fim;
	
	public BufferEntrada(String nome){
		
		init=0;
		fim=0;
		buffer=new ArrayList<Character>();
	      try {
	    	  arq = new FileReader(nome);
	
	    	  lerArq = new BufferedReader(arq);
	 
	    	  String linha = lerArq.readLine(); 
	    	  
	
	    	  while (linha != null) { 
	    		  
	    		  for(char c: linha.toCharArray())	    			  
	    			  buffer.add(c);
	    		  
	    		  linha = lerArq.readLine();
	    	  }
	 
	    	  arq.close();
	      } catch (IOException e) {
	    	  System.err.printf("Erro na abertura do arquivo: %s.\n",
	    	          e.getMessage());
		}

	}


	
	public char getNext() {
		
		
		return buffer.get(fim++);
	}
	
	public String getValue() {
		String s=buffer.get(init++).toString();
		while(init<fim)
			s+=buffer.get(init++).toString();
		
		return s;
	}
	
	public void returnOne() {
		init--;
		fim--;
	}

}
