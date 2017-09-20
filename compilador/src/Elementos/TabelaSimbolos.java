package Elementos;

import java.util.Hashtable;

public class TabelaSimbolos {
	
	private Hashtable<String, Integer> tabela;
	private Integer contador;

	public TabelaSimbolos() {

		this.tabela = new Hashtable<>();
	}
	
	public boolean consultaTabela(String str) {			
		return tabela.contains(str);
	}
	
	
	public void insereSimbolo(String str) {		
		tabela.put(str,	contador++);		
	}
	

}
