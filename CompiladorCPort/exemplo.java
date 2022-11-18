import java.util.Scanner;
public class Exemplo {
public static void main(String[] args){
int a;
int b;
int c;
int x;
Scanner teclado = new Scanner(System.in);
a = teclado.nextInt();
b = teclado.nextInt();
c = a + b;
if ( a > b ) {
System.out.print(a);
} else {
System.out.print(b);
}
System.out.println();
System.out.print("Soma de a e b");
System.out.println();
System.out.print("Soma de a e b");
System.out.print(c);
System.out.println();
for(x=1;x<=10;x++){
System.out.print(x);
System.out.println();
}
}
}
