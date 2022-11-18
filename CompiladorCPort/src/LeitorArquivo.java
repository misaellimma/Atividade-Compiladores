import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class LeitorArquivo {

	public LeitorArquivo() { }
	
	public List<String> lerArquivo(String nomeArquivo){
		List<String> conteudo = new ArrayList();
		String linha;

		try {
		   FileReader leitor = new FileReader(nomeArquivo);
		   BufferedReader buffer = new BufferedReader(leitor);

		   while ((linha = buffer.readLine()) != null) {
				conteudo.add(linha.trim());
		   }

		   buffer.close();
		   leitor.close();
		} catch (Exception e){
		   System.out.println("Erro:" + e.getMessage());
		}
		return conteudo;
	}
	
	public void Imprimir( List<String> conteudo) {
		for( int i = 0; i < conteudo.size(); i++) {
			System.out.println(conteudo.get(i));
		}
	}
	
	public void gravarArquivo( String nome, List<String> conteudo) {
		nome = nome.replace(".txt",".java");
		try {
			FileWriter gravador = new FileWriter(nome);
			BufferedWriter buffer = new BufferedWriter(gravador);
			
			for(String linha: conteudo) {
				buffer.write(linha);
				buffer.newLine();
			}
			
			buffer.close();
			gravador.close();
		} catch (Exception e){
			System.out.println("Erro:" + e.getMessage());
		}
	}

}
