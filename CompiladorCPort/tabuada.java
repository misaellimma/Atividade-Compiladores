import java.util.Scanner;
public class Tabuada {
public static void main(String[] args){
int a;
int b;
int x;
System.out.print("informe um numero para a tabuada: ");
Scanner teclado = new Scanner(System.in);
a = teclado.nextInt();
for(x=1;x<11;x++){
b = x * a;
System.out.print(x);
System.out.print(" X ");
System.out.print(a);
System.out.print(" = ");
System.out.print(b);
System.out.println();
}
}
}
