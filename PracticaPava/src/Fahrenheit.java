import java.util.Scanner;

public class Fahrenheit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Programa que lea una cantidad de grados centígrados y la pase a 
		 * grados Fahrenheit. La fórmula correspondiente para pasar 
		 * de grados centígrados a fahrenheit es: F = 32 + ( 9 * C / 5)*/
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese los grados en Celcius");
		double gradosCelcius = Double.parseDouble(sc.nextLine());
		Double gradosFahrenheit = 32 + ( 9 * gradosCelcius / 5);
		System.out.println(gradosCelcius + "ºC son " + gradosFahrenheit + "ºF");
		sc.close();

	}

}
