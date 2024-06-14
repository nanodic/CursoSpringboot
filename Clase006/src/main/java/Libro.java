import java.util.Objects;

    public abstract class  Libro implements Info {
        private String titulo;
        private String autor;
        private int Fecha;

        public Libro() {}

        public LibroDigital(String titulo, String autor, int fecha) {
            this.titulo = titulo;
            this.autor = autor;
            Fecha = fecha;
        }

        public String getTitulo() {
            return titulo;
        }

        public void setTitulo(String titulo) {
            this.titulo = titulo;
        }

        public String getAutor() {
            return autor;
        }

        public void setAutor(String autor) {
            this.autor = autor;
        }

        public int getFecha() {
            return Fecha;
        }

        public void setFecha(int fecha) {
            Fecha = fecha;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Libro libro = (Libro) o;
            return Fecha == libro.Fecha && Objects.equals(titulo, libro.titulo) && Objects.equals(autor, libro.autor);
        }

        @Override
        public int hashCode() {
            return Objects.hash(titulo, autor, Fecha);
        }

        // public abstract String getInfo();
    }


