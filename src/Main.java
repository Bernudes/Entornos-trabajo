//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculadora calculadora = new Calculadora();

        int opcion;

        do {
            System.out.println("La calculadora tiene las siguientes opciones:");
            System.out.println("1.- Sumar");
            System.out.println("2.- Restar");
            System.out.println("3.- Multiplicar");
            System.out.println("4.- Dividir");
            System.out.println("0.- Salir");
            System.out.print("¿Qué opción quieres realizar?: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    realizarOperacion(scanner, calculadora, Operacion.SUMA);
                    break;
                case 2:
                    realizarOperacion(scanner, calculadora, Operacion.RESTA);
                    break;
                case 3:
                    realizarOperacion(scanner, calculadora, Operacion.MULTIPLICACION);
                    break;
                case 4:
                    realizarOperacion(scanner, calculadora, Operacion.DIVISION);
                    break;
                case 0:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elige una opción del menú.");
            }
        } while (opcion != 0);

        scanner.close();
    }

    private static void realizarOperacion(Scanner scanner, Calculadora calculadora, Operacion operacion) {
        System.out.print("Introduce el primer número: ");
        double num1 = scanner.nextDouble();
        System.out.print("Introduce el segundo número: ");
        double num2 = scanner.nextDouble();

        double resultado = switch (operacion) {
            case SUMA -> calculadora.sumar(num1, num2);
            case RESTA -> calculadora.restar(num1, num2);
            case MULTIPLICACION -> calculadora.multiplicar(num1, num2);
            case DIVISION -> calculadora.dividir(num1, num2);
        };

        System.out.printf("El resultado es: %.3f\n", resultado);
    }
}

class Calculadora {

    public double sumar(double num1, double num2) {
        return num1 + num2;
    }

    public double restar(double num1, double num2) {
        return num1 - num2;
    }

    public double multiplicar(double num1, double num2) {
        return num1 * num2;
    }

    public double dividir(double num1, double num2) {
        if (num2 == 0) {
            System.out.println("Error: No se puede dividir entre cero.");
            return 0;
        } else {
            return num1 / num2;
        }
    }
}

enum Operacion {
    SUMA,
    RESTA,
    MULTIPLICACION,
    DIVISION
}
