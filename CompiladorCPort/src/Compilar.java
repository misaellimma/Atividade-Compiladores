import java.util.ArrayList;
import java.util.List;

public class Compilar {

	public List<String> programa;
	public List<String> alfabeto;
	public List<String> dicionario;
	public List<String> gramatica;

	public Compilar() {
		programa = new ArrayList();
		alfabeto = new ArrayList();
		dicionario = new ArrayList();
		gramatica = new ArrayList();
	}

	public void executar(String fonte) {
		LeitorArquivo leitor = new LeitorArquivo();

		try {
			String currentPath = new java.io.File(".").getCanonicalPath();
			System.out.println("Current dir:" + currentPath);

			programa = leitor.lerArquivo(fonte);
			alfabeto = leitor.lerArquivo("arquivos\\alfabeto.txt");
			dicionario = leitor.lerArquivo("arquivos\\dicionario.txt");
			gramatica = leitor.lerArquivo("arquivos\\gramatica.txt");

			AnalisadorLexico lexico = new AnalisadorLexico();
			AnalisadorSintatico sintatico = new AnalisadorSintatico();
			AnalisadorSemantico semantico = new AnalisadorSemantico();
			GeradorByteCode gerador = new GeradorByteCode(programa);

			if (lexico.validar(programa, alfabeto)) {
				System.out.println("\nAnalise Léxica OK");
				if (sintatico.validar(programa, gramatica)) {
					System.out.println("Analise Sintática OK");
					if (semantico.validar(programa, dicionario)) {
						System.out.println("Analise Semantica OK");
						gerador.gerar(fonte);
					}
				} else
					System.out.println("Erro na analise sintatica");
			} else {
				System.out.println("\nExistem erros na analise lexica...");
				return;
			}

		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
}
