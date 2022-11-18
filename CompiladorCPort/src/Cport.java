import java.util.Scanner;

public class Cport {
	public static void main(String[] args) {
		Compilar compilar= new Compilar();
		Scanner teclado = new Scanner(System.in);
		String nome;
		
		if (args.length == 0) {
			System.out.println("Digite o nome do arquivo:");
			nome = teclado.nextLine();
		} else
			nome = args[0];

		teclado.close();
		compilar.executar(nome);
	}
}
