package Analisadores;

import Auxiliar.BufferEntrada;
import Auxiliar.Tipos;
import Elementos.TabelaSimbolos;
import Elementos.Token;

public class AnalisadorLexico {
	
	
	private BufferEntrada buffer;
	private TabelaSimbolos ts;
	private Token tk;

	AnalisadorLexico(String endereco){
		
		buffer = new BufferEntrada(endereco);
		ts = new TabelaSimbolos();
		
	}
	
	public   Token lex(){
		char lookahead = buffer.getNext();
		int estado = 0;
		
		while(true) {//apenas aqui é para implementar
			switch(estado) {
			case 0:
				switch(lookahead) {
				case '\n':
				case ' ':
				case '\t':
					estado = 0;
					buffer.getValue();
					lookahead = buffer.getNext();					
					break;
				case 'A':
				
				case 'C':
				case 'D':
				case 'E':
				case 'F':
				case 'H':
				case 'J':
				case 'K':
				case 'L':
				case 'M':
				case 'N':
				case 'O':
				case 'P':
				case 'Q':
				case 'R':
				case 'S':
				case 'T':
				case 'U':
				case 'X':
				case 'Y':
				case 'Z':
					estado = 1;
					lookahead = buffer.getNext();
					break;
				case 'V':
					estado = 6;
					lookahead = buffer.getNext();
					break;
				case 'I':
					estado = 13;
					lookahead = buffer.getNext();
					break;
				case 'G':
					estado = 8;
					lookahead = buffer.getNext();
					break;
				case 'B':
					estado=/*Qual estado?*/;
					lookahead = buffer.getNext();
					break;
				case '0':
				case '1':
				case '2':
				case '3':
				case '4':
				case '5':
				case '6':
				case '7':
				case '8':
				case '9':
					estado = 20;
					lookahead = buffer.getNext();
					break;
				default:
					System.out.println("Erro na sequencia "+ buffer.getValue());
					while(lookahead != ' '||lookahead != '\n'||lookahead != '\t')
						lookahead =buffer.getNext(); 
					estado =0;
				
				}
				break;
			case 1:
				switch(lookahead) {
				case 'A':
				case 'B':
				case 'C':
				case 'D':
				case 'E':
				case 'F':
				case 'H':
				case 'J':
				case 'K':
				case 'L':
				case 'M':
				case 'N':
				case 'O':
				case 'P':
				case 'Q':
				case 'R':
				case 'S':
				case 'T':
				case 'U':
				case 'X':
				case 'Y':
				case 'Z':
				case 'V':
				case 'I':
				case 'G':
					estado = 2;
					lookahead = buffer.getNext();
					break;
				default:
			
			
				}
				break;
			case 2:
				switch(lookahead) {
				case 'A':
				case 'B':
				case 'C':
				case 'D':
				case 'E':
				case 'F':
				case 'H':
				case 'J':
				case 'K':
				case 'L':
				case 'M':
				case 'N':
				case 'O':
				case 'P':
				case 'Q':
				case 'R':
				case 'S':
				case 'T':
				case 'U':
				case 'X':
				case 'Y':
				case 'Z':
				case 'V':
				case 'I':
				case 'G':
					estado = 3;
					lookahead = buffer.getNext();
					break;
				default:
			
			
				}
				break;
			case 3:
				switch(lookahead) {
				case '0':
				case '1':
				case '2':
				case '3':
				case '4':
				case '5':
				case '6':
				case '7':
				case '8':
				case '9':
					estado = 4;
					lookahead = buffer.getNext();
					break;
				default:
			
			
				}
				break;
			case 4:
				tk = new Token();
				tk.setTipo(Tipos.VAR);
				tk.setValor((String)buffer.getValue());
				if(!ts.consultaTabela((String)tk.getValor()))
					ts.insereSimbolo((String)buffer.getValue());
				
				return tk;
			
			case 6:
				switch(lookahead) {
				case 'A':
				case 'B':
				case 'C':
				case 'D':
				case 'E':
				case 'F':
				case 'H':
				case 'J':
				case 'K':
				case 'L':
				case 'M':
				case 'N':
				case 'O':
				case 'P':
				case 'Q':
				case 'R':
				case 'S':
				case 'T':
				case 'U':
				case 'X':
				case 'Y':
				case 'Z':
				case 'V':
				case 'I':
				case 'G':
					estado =2;
					lookahead = buffer.getNext();
					break;
				case ':':
					estado = 7;
					break;
				default:
					
				}
				break;
			case 7:	
				tk = new Token();
				tk.setTipo(Tipos.DEFVAR);
				return tk;
				
			case 8: 
				switch(lookahead) {
					case 'A':
					case 'B':
					case 'C':
					case 'D':
					case 'E':
					case 'F':
					case 'H':
					case 'J':
					case 'K':
					case 'L':
					case 'M':
					case 'N':
					
					case 'P':
					case 'Q':
					case 'R':
					case 'S':
					case 'T':
					case 'U':
					case 'X':
					case 'Y':
					case 'Z':
					case 'V':
					case 'I':
					case 'G':
						estado = 2;
						lookahead= buffer.getNext();
						break;
					case 'O':
						estado =9;
						lookahead=buffer.getNext();
						break;
					default:
				}
				break;
			case 9:
				switch(lookahead) {
					case 'A':
					case 'B':
					case 'C':
					case 'D':
					case 'E':
					case 'F':
					case 'H':
					case 'J':
					case 'K':
					case 'L':
					case 'M':
					case 'N':
					case 'O':
					case 'P':
					case 'Q':
					case 'R':
					case 'S':
					
					case 'U':
					case 'X':
					case 'Y':
					case 'Z':
					case 'V':
					case 'I':
					case 'G': 
						estado = 3;
						lookahead = buffer.getNext();
						break;
					case 'T':
						estado = 10;
						lookahead = buffer.getNext();
						break;
					default:
						
				
				}
				break;
			case 10:
				switch(lookahead) {
					case 'O':
						estado = 11;
						break;
					case '0':
					case '1':
					case '2':
					case '3':
					case '4':
					case '5':
					case '6':
					case '7':
					case '8':
					case '9':
						estado=4;
						break;
					default:
						
				}
			
				break;
			case 11:
				tk = new Token();
				tk.setTipo(Tipos.SALTO);
				return tk;			
			
			case 12:
				switch(lookahead) {
				case 'A':
				case 'B':
				case 'C':
				case 'D':
				case 'E':
				
				case 'H':
				case 'J':
				case 'K':
				case 'L':
				case 'M':
				case 'N':
				case 'O':
				case 'P':
				case 'Q':
				case 'R':
				case 'S':
				case 'T':
				case 'U':
				case 'X':
				case 'Y':
				case 'Z':
				case 'V':
				case 'I':
				case 'G':
					estado = 2;
					lookahead = buffer.getNext();
					break;
				case 'F':
					estado = 13;
					lookahead = buffer.getNext();
					break;
				default:
			
			
				}
				break;
			case 13:
				tk = new Token();
				tk.setTipo(Tipos.SE);
				return tk;
			case 20:
			case '0':
			case '1':
			case '2':
			case '3':
			case '4':
			case '5':
			case '6':
			case '7':
			case '8':
			case '9':
				estado=20;
				lookahead = buffer.getNext();
				break;
			case '.':
				estado = 22;
				lookahead = buffer.getNext();
				break;
			default:
		}	
		
		return null;
		}
	
	

	}
}
