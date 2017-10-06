package Analisadores;

import Auxiliar.BufferEntrada;
import Auxiliar.Tipos;
import Elementos.TabelaSimbolos;
import Elementos.Token;

public class AnalisadorLexico {

	private BufferEntrada buffer;
	private TabelaSimbolos ts;
	private Token tk;

	AnalisadorLexico(String endereco) {

		buffer = new BufferEntrada(endereco);
		ts = new TabelaSimbolos();

	}

	public Token lex() {
		char lookahead = buffer.getNext();
		int estado = 0;

		while (true) {// apenas aqui é para implementar
			switch (estado) {
			case 0:
				switch (lookahead) {
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
				case 'S':
				case 'T':
				case 'U':
				case 'X':
				case 'Y':
				case 'Z':
					estado = 1;
					lookahead = buffer.getNext();
					break;
				case 'E':
					estado = 19;
					lookahead = buffer.getNext();
					break;
				case 'V':
					estado = 6;
					lookahead = buffer.getNext();
					break;
				case 'I':
					estado = 12;
					lookahead = buffer.getNext();
					break;
				case 'G':
					estado = 8;
					lookahead = buffer.getNext();
					break;
				case 'B':
					estado = 14;
					lookahead = buffer.getNext();
					break;
				case 'R':
					estado = 22;
					lookahead = buffer.getNext();
					break;
				case 'W':
					estado = 26;
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
					estado = 31;
					lookahead = buffer.getNext();
					break;
				case '(':
					estado = 41;
					lookahead = buffer.getNext();
					break;
				case ')':
					estado = 42;
					lookahead = buffer.getNext();
					break;
				case '+':
					estado = 43;
					lookahead = buffer.getNext();
					break;
				case '-':
					estado = 44;
					lookahead = buffer.getNext();
					break;
				case '*':
					estado = 45;
					lookahead = buffer.getNext();
					break;
				case '/':
					estado = 46;
					lookahead = buffer.getNext();
					break;
				case '%':
					estado = 46;
					lookahead = buffer.getNext();
					break;
				case ';':
					estado = 47;
					lookahead = buffer.getNext();
					break;
				case '>':
					estado = 48;
					lookahead = buffer.getNext();
					break;
				case '<':
					estado = 49;
					lookahead = buffer.getNext();
					break;
				case '=':
					estado = 35;
					lookahead = buffer.getNext();
					break;
				case ':':
					estado = 37;
					lookahead = buffer.getNext();
					break;
				case '!':
					estado = 39;
					lookahead = buffer.getNext();
					break;

				default:
					System.out.println("Erro na sequencia " + buffer.getValue());
					while (lookahead != ' ' || lookahead != '\n' || lookahead != '\t')
						lookahead = buffer.getNext();
					estado = 0;

				}
				break;
			case 1:
				switch (lookahead) {
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
				switch (lookahead) {
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
				switch (lookahead) {
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
				tk.setValor((String) buffer.getValue());
				if (!ts.consultaTabela((String) tk.getValor()))
					ts.insereSimbolo((String) buffer.getValue());

				return tk;

			case 6:
				switch (lookahead) {
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
				switch (lookahead) {
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
					lookahead = buffer.getNext();
					break;
				case 'O':
					estado = 9;
					lookahead = buffer.getNext();
					break;
				default:
				}
				break;
			case 9:
				switch (lookahead) {
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
				switch (lookahead) {
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
					estado = 4;
					break;
				default:

				}

				break;
			case 11:
				tk = new Token();
				tk.setTipo(Tipos.SALTO);
				return tk;

			case 12:
				switch (lookahead) {
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

			case 14:
				switch (lookahead) {
				case 'A':
				case 'B':
				case 'C':
				case 'D':

				case 'F':
				case 'G':
				case 'H':
				case 'I':
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
				case 'V':
				case 'W':
				case 'X':
				case 'Y':
				case 'Z':
					estado = 2;
					lookahead = buffer.getNext();
					break;
				case 'E':
					estado = 15;
					lookahead = buffer.getNext();
					break;
				default:

				}
				break;

			case 15:
				switch (lookahead) {
				case 'A':
				case 'B':
				case 'C':
				case 'D':
				case 'E':
				case 'F':

				case 'H':
				case 'I':
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
				case 'V':
				case 'W':
				case 'X':
				case 'Y':
				case 'Z':
					estado = 3;
					lookahead = buffer.getNext();
					break;
				case 'G':
					estado = 16;
					lookahead = buffer.getNext();
					break;
				default:

				}
				break;
			case 16:
				switch (lookahead) {
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

				case 'I':
					estado = 17;
					lookahead = buffer.getNext();
					break;
				default:

				}
				break;
			case 17:
				switch (lookahead) {
				case 'N':
					estado = 18;
					lookahead = buffer.getNext();
					break;
				default:
					System.out.println("Erro na sequencia " + buffer.getValue());
					while (lookahead != ' ' || lookahead != '\n' || lookahead != '\t')
						lookahead = buffer.getNext();
					estado = 0;
				}
				break;

			case 18:
				tk = new Token();
				tk.setTipo(Tipos.INICIO);
				return tk;

			case 19:
				switch (lookahead) {
				case 'A':
				case 'B':
				case 'C':
				case 'D':
				case 'E':
				case 'F':
				case 'G':
				case 'H':
				case 'I':
				case 'J':
				case 'K':
				case 'L':
				case 'M':

				case 'O':
				case 'P':
				case 'Q':
				case 'R':
				case 'S':
				case 'T':
				case 'U':
				case 'V':
				case 'W':
				case 'X':
				case 'Y':
				case 'Z':
					estado = 2;
					lookahead = buffer.getNext();
					break;

				case 'N':
					estado = 20;
					lookahead = buffer.getNext();
					break;
				default:

				}
				break;

			case 20:
				switch (lookahead) {
				case 'A':
				case 'B':
				case 'C':

				case 'E':
				case 'F':
				case 'G':
				case 'H':
				case 'I':
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
				case 'V':
				case 'W':
				case 'X':
				case 'Y':
				case 'Z':
					estado = 3;
					lookahead = buffer.getNext();
					break;
				case 'D':
					estado = 21;
					lookahead = buffer.getNext();
					break;
				default:

				}
				break;
			case 21:
				tk = new Token();
				tk.setTipo(Tipos.FIM);
				return tk;

			case 22:
				switch (lookahead) {
				case 'A':
				case 'B':
				case 'C':
				case 'D':

				case 'F':
				case 'G':
				case 'H':
				case 'I':
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
				case 'V':
				case 'W':
				case 'X':
				case 'Y':
				case 'Z':
					estado = 2;
					lookahead = buffer.getNext();
					break;
				case 'E':
					estado = 23;
					lookahead = buffer.getNext();
					break;
				default:

				}
				break;

			case 23:
				switch (lookahead) {

				case 'B':
				case 'C':
				case 'D':
				case 'E':
				case 'F':
				case 'G':
				case 'H':
				case 'I':
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
				case 'V':
				case 'W':
				case 'X':
				case 'Y':
				case 'Z':
					estado = 3;
					lookahead = buffer.getNext();
					break;
				case 'A':
					estado = 24;
					lookahead = buffer.getNext();
					break;
				default:

				}
				break;

			case 24:
				switch (lookahead) {
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

				case 'D':
					estado = 25;
					lookahead = buffer.getNext();
					break;
				default:
					System.out.println("ERRO");
				}
				break;

			case 25:
				tk = new Token();
				tk.setTipo(Tipos.OPLER);
				return tk;

			case 26:
				switch (lookahead) {
				case 'A':
				case 'B':
				case 'C':
				case 'D':
				case 'E':
				case 'F':
				case 'G':
				case 'H':
				case 'I':
				case 'J':
				case 'K':
				case 'L':
				case 'M':
				case 'N':
				case 'O':
				case 'P':
				case 'Q':
				case 'S':
				case 'T':
				case 'U':
				case 'V':
				case 'W':
				case 'X':
				case 'Y':
				case 'Z':
					estado = 2;
					lookahead = buffer.getNext();
					break;
				case 'R':
					estado = 27;
					lookahead = buffer.getNext();
					break;
				default:

				}
				break;

			case 27:
				switch (lookahead) {
				case 'A':
				case 'B':
				case 'C':
				case 'D':
				case 'E':
				case 'F':
				case 'G':
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
				case 'V':
				case 'W':
				case 'X':
				case 'Y':
				case 'Z':
					estado = 3;
					lookahead = buffer.getNext();
					break;
				case 'I':
					estado = 28;
					lookahead = buffer.getNext();
					break;
				default:

				}
				break;

			case 28:
				switch (lookahead) {
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

				case 'T':
					estado = 29;
					lookahead = buffer.getNext();
					break;
				default:
					System.out.println("ERRO");
				}
				break;

			case 29:
				switch (lookahead) {
				case 'E':
					estado = 30;
					lookahead = buffer.getNext();
					break;
				default:
					System.out.println("Erro na sequencia " + buffer.getValue());
					while (lookahead != ' ' || lookahead != '\n' || lookahead != '\t')
						lookahead = buffer.getNext();
					estado = 0;
				}
				break;

			case 30:
				tk = new Token();
				tk.setTipo(Tipos.OPESCRE);
				return tk;

			case 31:
				switch (lookahead) {
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
					estado = 31;
					lookahead = buffer.getNext();
					break;
				case '.':
					estado = 32;
					lookahead = buffer.getNext();
					break;
				case ';':
					estado = 33;
					lookahead = buffer.getNext();
					break;
				default:
					System.out.println("Erro na sequencia " + buffer.getValue());
					while (lookahead != ' ' || lookahead != '\n' || lookahead != '\t')
						lookahead = buffer.getNext();
					estado = 0;
				}
				break;

			case 32:
				switch (lookahead) {
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
					estado = 32;
					lookahead = buffer.getNext();
					break;
				case ';':
					estado = 34;
					lookahead = buffer.getNext();
					break;
				default:
					System.out.println("Erro na sequencia " + buffer.getValue());
					while (lookahead != ' ' || lookahead != '\n' || lookahead != '\t')
						lookahead = buffer.getNext();
					estado = 0;
				}
				break;

			case 33:
				tk = new Token();
				tk.setTipo(Tipos.NUMINT);
				return tk;

			case 34:
				tk = new Token();
				tk.setTipo(Tipos.NUMREAL);
				return tk;
			
			case 35:
				switch (lookahead) {
				case '=':				
					estado = 36;
					lookahead = buffer.getNext();
					break;			
				default:
					System.out.println("Erro na sequencia " + buffer.getValue());
					while (lookahead != ' ' || lookahead != '\n' || lookahead != '\t')
						lookahead = buffer.getNext();
					estado = 0;
				}
				break;
				
			case 36:
				tk = new Token();
				tk.setTipo(Tipos.OPIGUAL);
				return tk;
				
			case 37:
				switch (lookahead) {
				case '=':				
					estado = 38;
					lookahead = buffer.getNext();
					break;			
				default:
					System.out.println("Erro na sequencia " + buffer.getValue());
					while (lookahead != ' ' || lookahead != '\n' || lookahead != '\t')
						lookahead = buffer.getNext();
					estado = 0;
				}
				break;
				
			case 38:
				tk = new Token();
				tk.setTipo(Tipos.OPATRIB);
				return tk;
			
			case 39:
				switch (lookahead) {
				case '=':				
					estado = 40;
					lookahead = buffer.getNext();
					break;			
				default:
					System.out.println("Erro na sequencia " + buffer.getValue());
					while (lookahead != ' ' || lookahead != '\n' || lookahead != '\t')
						lookahead = buffer.getNext();
					estado = 0;
				}
				break;
				
			case 40:
				tk = new Token();
				tk.setTipo(Tipos.OPDIF);
				return tk;

			case 41:
				tk = new Token();
				tk.setTipo(Tipos.TABREPARENTESES);
				return tk;
			case 42:
				tk = new Token();
				tk.setTipo(Tipos.TFECHAPARENTESES);
				return tk;
			case 43:
				tk = new Token();
				tk.setTipo(Tipos.OPSOMA);
				return tk;
			case 44:
				tk = new Token();
				tk.setTipo(Tipos.OPSUBTRAI);
				return tk;
			case 45:
				tk = new Token();
				tk.setTipo(Tipos.OPMULT);
				return tk;
			case 46:
				tk = new Token();
				tk.setTipo(Tipos.OPDIV);
				return tk;
			case 47:
				tk = new Token();
				tk.setTipo(Tipos.INSTFIM);
				return tk;
			case 48:
				tk = new Token();
				tk.setTipo(Tipos.OPMAIOR);
				return tk;
			case 49:
				tk = new Token();
				tk.setTipo(Tipos.OPMENOR);
				return tk;
				
			
			// FIM SWITCH CASE PRINCIPAL
			}

			return null;
		}

	}
}
