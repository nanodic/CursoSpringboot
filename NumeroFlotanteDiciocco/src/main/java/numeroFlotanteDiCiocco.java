import java.util.Scanner;

public class numeroFlotanteDiCiocco
{
    public static void main (String[] args)
    {

        System.out.println("=====================================================");
        System.out.println("Bienvenido al programa separador de números flotantes");
        System.out.println("=====================================================");
        System.out.println("Por favor, ingrese un numeros flotante ej  10,23 (separador, coma)");

       //se crea la variable para almacenar el valor ingresado por consola
        Scanner sc = new Scanner(System.in);

        //se captura el valor ingresado
        float numeroFlotante = sc.nextFloat();

        System.out.println("Procesando...");
        System.out.println("=====================================================");
        System.out.println("El numero ingresado es: " + numeroFlotante);
        System.out.println("=====================================================");

        // se obtiene la parte entera convirtiendo el tipo de dato
        int parteEntera = (int) numeroFlotante;
        // se realia la resta sobre el numero original para recuperar la parte decimal
        double parteDecimal = numeroFlotante - parteEntera;
        // se imprime por pantalla el resultado

        System.out.println("El valor de la parte entera es: " + parteEntera);
        System.out.println("El valor de la parte decimal es: " + parteDecimal);
        System.out.println("=====================================================");
        System.out.println("FIN");
       }

}
