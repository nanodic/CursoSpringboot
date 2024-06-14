
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Libro> libros;
    public Biblioteca(){
        this.libros = new ArrayList<>();
    }

    public List<Libro> mostrarLibros() {
        return libros;
    }

    public void agregarLibro (Libro libro){
        this.libros.add(libro);
        System.out.println("Se agrego el libro correctamente");
    }

    public Libro buscarLibroPorTitulo (String titulo) throws Exception {
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                return libro;
            }
        }
        throw new Exception("Libro no entonctrado!");
    }
}
