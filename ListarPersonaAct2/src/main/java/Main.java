import java.util.*;

public class Main {


    public static void main(String[] args) {



        System.out.println("*******************************");
        System.out.println("CARGANDO LISTA DE PERSONAS...");
        System.out.println("*******************************");

        //SE CREAM LAS 5 INSTANCIAS DE LAS PERSONAS CON SUS CORRESPONDIENTES ATRIBUTOS

        Persona persona1 = new Persona("Lionel", "Messi");
        Persona persona2 = new Persona("Juan Roman", "Riquelme");
        Persona persona3 = new Persona("Carlos", "Tevez");
        Persona persona4 = new Persona("Andres", "Iniesta");
        Persona persona5 = new Persona("Martin", "Palermo");

        //SE INICIALIZA LISTA Y SE AGREGAN LOS OBJECTOS CREADOS

        List<Persona> listaPersona = new ArrayList<>();
        listaPersona.add((persona1));
        listaPersona.add((persona2));
        listaPersona.add((persona3));
        listaPersona.add((persona4));
        listaPersona.add((persona5));

        //SE INICIA LA LECTURA POR CONSOLA PARA DAR AL USUARIO LA OPCION DE MOSTRAR LA LISTA A SU GUSTO
        //SE CREA UN BUCLE PARA QUE DICHO PROCESO SE REPITA HASTA SE SELECCIONE UNA OPCION DE SALIDA

        Scanner sc = new Scanner(System.in);
        int opcion;

        do {

            System.out.println("\n");
            System.out.println("Ingrese la opcion a ejecutar: ej (1)");
            System.out.println("1 - Listar todos los nombres  ");
            System.out.println("2 - Listar ordenado por nombres ");
            System.out.println("3 - Listar ordenado por apellidos descendente ");
            System.out.println("4 - Listar ordenado por apellidos inversos ");
            System.out.println("5 o mayor - Salir " + "\n");


            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("LISTANDO OPCION 1");
                    for (Persona persona : listaPersona) {
                        System.out.println(persona);
                    }
                    break;
                case 2:
                    System.out.println("LISTANDO OPCION 2");
                    listaPersona.sort(Comparator.comparing(Persona::getNombre));
                    for (Persona persona : listaPersona) {
                        System.out.println(persona);
                    }
                    break;
                case 3:
                    System.out.println("LISTANDO OPCION 3");
                    listaPersona.sort(Comparator.comparing(Persona::getApellido).reversed());
                    for (Persona persona : listaPersona) {
                        System.out.println(persona);
                    }
                    break;
                case 4:
                    System.out.println("LISTANDO OPCION 4");
                    Collections.reverse(listaPersona);
                    for (Persona persona : listaPersona) {
                        System.out.println(persona);
                    }
                    break;
                default:
                        System.out.println("Opción incorrecta" + "\n");
            }
        } while (opcion < 5);

        System.out.println("Fin de programa. Saliendo...");
    }
}