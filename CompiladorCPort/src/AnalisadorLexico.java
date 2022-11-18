import java.util.List;

public class AnalisadorLexico {

	public AnalisadorLexico() {	}
	
	public Boolean validar(List<String> programa, List<String> alfabeto) {
		
		char letra;
		boolean achou;
		
		for(String linha: programa) {
			for (int i = 0; i < linha.length(); i++) {
				letra = linha.charAt(i);
				achou = estaNoAlfabeto(letra, alfabeto);

				if (!achou) {
					System.out.println("Letra ." + letra + ". nao encontrada");
					return false;
				}
			}
		}

		return true;
	}
	
	public Boolean estaNoAlfabeto( char letra, List<String> alfabeto) {
		String alfa = alfabeto.get(0);
		
		for(int i=0;i<alfa.length();i++) {
			if (letra == ' ') return true;
			if (letra == alfa.charAt(i)) return true;
		}

		return false;
	}

}
