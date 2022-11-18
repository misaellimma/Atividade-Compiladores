import java.util.Scanner;
public class Fatorial {
public static void main(String[] args){
int a;
int b;
int c;
int x;
System.out.print("informe o numero para calcular o fatorial: ");
Scanner teclado = new Scanner(System.in);
a = teclado.nextInt();
c = 1;
for(x=1;x<a;x++){
b = x + 1;
c = b * c;
}
System.out.print("fatorial de ");
System.out.print(a);
System.out.print(" eh ");
System.out.print(c);
}
}
