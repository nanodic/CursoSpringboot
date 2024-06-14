package clases;

import jakarta.persistence.*;

import java.util.Objects;

//TAG de entidad
@Entity
public class Clients {

    //Id autogenerado - ClavePrimaria
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    //Definicion de columnas de la tabla
    @Column
    private String name;
    @Column
    private String lastName;
    @Column
    private Integer document;


    //Constructor
    public Clients(String name, String lastName, Integer document) {
        this.name = name;
        this.lastName = lastName;
        this.document = document;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String apellido) {
        this.lastName = apellido;
    }

    public Integer getDocument() {
        return document;
    }

    public void setDocument(Integer documento) {
        this.document = documento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clients clients = (Clients) o;
        return Objects.equals(id, clients.id) && Objects.equals(name, clients.name) && Objects.equals(lastName, clients.lastName) && Objects.equals(document, clients.document);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastName, document);
    }

    @Override
    public String toString() {
        return "Clients{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", apellido='" + lastName + '\'' +
                ", documento=" + document +
                '}';
    }
}
