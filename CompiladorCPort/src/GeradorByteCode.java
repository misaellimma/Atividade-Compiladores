import java.util.ArrayList;
import java.util.List;

public class GeradorByteCode {

	public List<String> byteCode;
	public List<String> fonte;
	public Boolean jaExisteScanner;

	public GeradorByteCode(List<String> fonte) {
		this.fonte = fonte;
	}

	public Boolean gerar(String nomeArquivo) {
		String nomeClasse;
		System.out.println(nomeArquivo);
		nomeClasse = limparNome(nomeArquivo);
		jaExisteScanner = false;
		byteCode = new ArrayList<>();

		for (String linha : fonte) {
			gerarInicio(linha, nomeClasse);
			gerarFim(linha);
			gerarInteiro(linha);
			gerarLeia(linha);
			gerarOperacaoAritmetica(linha);
			gerarEscreva(linha);
			gerarSe(linha);
			gerarSenao(linha);
			gerarFimSe(linha);
			gerarConte(linha);
			gerarFimConte(linha);
			gerarPulaLinha(linha);
		}

		for (String linha : byteCode) {
			System.out.println(linha);
		}

		gravar(nomeArquivo, byteCode);
		return true;
	}

	public void gerarInicio(String linha, String nome) {
		if (!linha.equals("programa"))
			return;

		byteCode.add("import java.util.Scanner;");
		byteCode.add("public class " + nome + " {");
		byteCode.add("public static void main(String[] args){");
	}

	public void gerarFim(String linha) {
		if (!linha.equals("fimprograma"))
			return;

		byteCode.add("}");
		byteCode.add("}");
	}

	public void gerarInteiro(String linha) {
		if (!linha.startsWith("variavel"))
			return;

		byteCode.add(linha.replace("variavel", "int") + ";");
	}

	public void gerarLeia(String linha) {
		if (!linha.startsWith("obter"))
			return;

		if (!jaExisteScanner) {
			byteCode.add("Scanner teclado = new Scanner(System.in);");
			jaExisteScanner = true;
		}

		byteCode.add(linha.replace("obter ", "") + " = teclado.nextInt();");
	}

	public void gerarOperacaoAritmetica(String linha) {
		if (linha.contains("+") || linha.contains("-") || linha.contains("*") || linha.contains("/")) {
			byteCode.add(linha.replace("<-", "=") + ";");
		}
	}

	public void gerarEscreva(String linha) {
		if (!linha.startsWith("mostre"))
			return;

		linha = linha.replace("'", "\"");
		byteCode.add(linha.replace("mostre ", "System.out.print(") + ");");
	}

	public void gerarSe(String linha) {
		if (!linha.startsWith("compare"))
			return;

		linha = linha.replace("compare", "if (");
		linha = linha.replace("entao", ") {");
		byteCode.add(linha);
	}

	public void gerarSenao(String linha) {
		if (!linha.startsWith("senao"))
			return;

		linha = linha.replace("senao", "} else {");
		byteCode.add(linha);
	}

	public void gerarFimSe(String linha) {
		if (!linha.startsWith("fimcompare"))
			return;

		linha = linha.replace("fimcompare", "}");
		byteCode.add(linha);
	}

	public void gerarConte(String linha) {
		if (!linha.startsWith("para"))
			return;

		String[] token = linha.split(" ");

		String novaLinha = "for(" + token[1] + "=" + token[3] + ";" + token[1] + "<=" +
						   token[5] + ";" + token[1] + "++" + "){";

		byteCode.add(novaLinha);
	}

	public void gerarFimConte(String linha) {
		if (!linha.startsWith("fimpara"))
			return;

		linha = linha.replace("fimpara", "}");
		byteCode.add(linha);
	}

	public void gerarPulaLinha(String linha) {
		if (!linha.startsWith("pular"))
			return;

		linha = linha.replace("pular", "System.out.println();");
		byteCode.add(linha);
	}

	public String limparNome(String nome) {
		nome = nome.replace("\\", " ").replace(".txt", "");

		String[] token = nome.split(" ");
		String novoNome = token[token.length - 1];

		novoNome = novoNome.substring(0, 1).toUpperCase() + novoNome.substring(1).toLowerCase();
		System.out.println(novoNome);
		return novoNome;
	}

	public void gravar(String nome, List<String> byteCode) {
		LeitorArquivo gravador = new LeitorArquivo();
		gravador.gravarArquivo(nome, byteCode);
	}

}
