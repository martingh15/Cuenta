import java.util.Scanner;

public class SumaDosNumeros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a,b;
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese un numero entero");
		a = Integer.parseInt(sc.nextLine());
		System.out.println("Ingrese otro numero entero");
		b = Integer.parseInt(sc.nextLine());
		System.out.println("Los numeros son: " + a + " y " + b);
		sc.close();
	}

}
