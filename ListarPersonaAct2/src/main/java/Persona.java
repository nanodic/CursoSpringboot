public class Persona {

    //DECLARACION DE ATRIBUTOS PERSONA

    String nombre;
    String apellido;

    //CONSTRUCTOR

    public Persona(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    //METODOS SET Y GETT
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    //SOBRECARGA DEL METODO PARA IMPRIMIR POR PANTALLA LA CONCATENACION DE DATOS

    public String toString() {
        return nombre + " " + apellido;
    }
}
