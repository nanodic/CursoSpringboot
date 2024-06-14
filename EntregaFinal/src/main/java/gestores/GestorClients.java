package gestores;

import clases.Clients;
import jakarta.persistence.EntityManager;
import java.util.List;

public class GestorClients {

    public void create (String name, String lastName, Integer document)
    {
        EntityManager entityManager = GestorGenerico.getEntityManager();
        entityManager.getTransaction().begin();
        Clients clients = new Clients(name,lastName,document);
        entityManager.persist(clients);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public List<Clients> readAll()
    {
        EntityManager entityManager = GestorGenerico.getEntityManager();
        List<Clients> clients = entityManager.createQuery("FROM Clients", Clients.class).getResultList();
        entityManager.close();
        return clients;
    }

    public Clients readById (Integer id)
    {
        EntityManager entityManager = GestorGenerico.getEntityManager();
        Clients clients = entityManager.find(Clients.class,id);
        entityManager.close();
        return clients;
    }

    public void update (Integer id,String name, String lastName, Integer document)
    {
        EntityManager entityManager = GestorGenerico.getEntityManager();
        entityManager.getTransaction().begin();
        Clients clients = entityManager.find(Clients.class,id);
        if (clients != null)
        {
            if (name !=null) {clients.setName(name);}
            if (lastName !=null) {clients.setLastName(lastName);}
            if (document != null) {clients.setDocument(document);}
            entityManager.merge(clients);
            entityManager.getTransaction().commit();
        }
        entityManager.close();
    }

    public void Delete(Integer id){
        EntityManager entityManager = GestorGenerico.getEntityManager();
        entityManager.getTransaction().begin();
        Clients clients = entityManager.find(Clients.class,id);
        if (clients != null)
        { entityManager.remove(clients);
         entityManager.getTransaction().commit();
        }
        entityManager.close();
    }
}
