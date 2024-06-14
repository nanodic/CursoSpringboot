package java_08_jpa;

import jakarta.persistence.EntityManager;

import java.util.List;

public class GestorCliente {

    public void create (String nombre, String apellido, Integer dni, Integer edad)
    {
        EntityManager manager = GestorGenerico.getEntityManager();
        manager.getTransaction().begin();
        Cliente cliente = new Cliente (nombre,apellido,dni,edad);
        manager.persist(cliente);
        manager.getTransaction().commit();
        manager.close();
    }

    public List<Cliente> readAll ()
    {
        EntityManager manager = GestorGenerico.getEntityManager();
        List<Cliente> lista = manager.createQuery("From cliente", Cliente.class).getResultList();
        manager.close();
        return lista;
    }

}
