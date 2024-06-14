package java06abstracta;

public class LibroImpreso extends Libro{

    private int numeroPaginas;

    public LibroImpreso(String titulo, String autor, int fecha, int numeroPaginas) {
        super(titulo, autor, fecha);
        this.numeroPaginas = numeroPaginas;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    @Override
    public String getInfo() {
        return "El libroImpreso tiene" + this.getNumeroPaginas() + "y es del autor"+ this.getAutor();
    }
}
