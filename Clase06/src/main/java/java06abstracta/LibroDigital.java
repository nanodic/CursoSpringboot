package java06abstracta;

public class LibroDigital extends Libro{

    private double pesoArchivo;

    public LibroDigital(String titulo, String autor, int fecha, double pesoArchivo) {
        super(titulo, autor, fecha);
        this.pesoArchivo = pesoArchivo;
    }

    public double getPesoArchivo() {
        return pesoArchivo;
    }

    public void setPesoArchivo(double pesoArchivo) {
        this.pesoArchivo = pesoArchivo;
    }

    public String getInfo(){
        return "El libroDigital se llama" + this.getTitulo() + "y pesa" + this.getPesoArchivo();
    }


}
