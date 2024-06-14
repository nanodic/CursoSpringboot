package java06abstracta;

public class Test {

    public static void main(String[] args) {
        try {
            Biblioteca biblioteca = new Biblioteca();

            Libro digital1 = new LibroDigital("java1", "Nahuel Di CIocco", 2020, 200);
            biblioteca.agregarLibro(digital1);
            // System.out.println(digital1.getTitulo());
            Libro digital2 = new LibroDigital("php1", "Nahuel Di CIocco", 2000, 100);
            biblioteca.agregarLibro(digital2);
            // System.out.println(digital2.getAutor());
            // System.out.println(digital2.getInfo());
            Libro impreso1 = new LibroImpreso("Programando java", "Marcos Gutierrez", 2017, 500);
            biblioteca.agregarLibro(impreso1);
            // System.out.println(impreso1.getTitulo());
            Libro impreso2 = new LibroImpreso("php Impreso", "Marcos Gutierrez", 2012, 2000);
            biblioteca.agregarLibro(impreso2);
            // System.out.println(impreso2.getAutor());
            // System.out.println(impreso2.getInfo());
            for (Libro libro : biblioteca.mostrarLibros()) {
                System.out.println(libro.getTitulo());
            }
            System.out.println(biblioteca.buscarLibroPorTitulo("php Impreso").getInfo());
            System.out.println(biblioteca.buscarLibroPorTitulo("java").getInfo());
        }
        catch (Exception exception){
            System.out.println(exception);
        }

    }

}
