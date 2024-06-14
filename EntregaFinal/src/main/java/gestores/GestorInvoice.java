package gestores;

import clases.Clients;
import clases.Invoice;
import jakarta.persistence.EntityManager;

import java.util.Date;
import java.util.List;


public class GestorInvoice {

    public void create(Integer clientId, Date created_at, Double total) {
        EntityManager entityManager = GestorGenerico.getEntityManager();
        entityManager.getTransaction().begin();
        Invoice invoice  = new Invoice(clientId,created_at, total);
        entityManager.persist(invoice);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public List<Invoice> readAll() {
        EntityManager entityManager = GestorGenerico.getEntityManager();
        List<Invoice> invoice = entityManager.createQuery("FROM Invoice", Invoice.class).getResultList();
        entityManager.close();
        return invoice;
    }

    public Invoice readById(Integer id) {
        EntityManager entityManager = GestorGenerico.getEntityManager();
        Invoice invoice  = entityManager.find(Invoice.class, id);
        entityManager.close();
        return invoice;
    }

    public void update(Integer id, Integer clientId, Date created_at, Double total) {
        EntityManager entityManager = GestorGenerico.getEntityManager();
        entityManager.getTransaction().begin();
        Invoice invoice = entityManager.find(Invoice.class, id);
        if (invoice != null) {
            if (clientId != null) {
                invoice.setClientId(clientId);
            }
            if (created_at != null) {
                invoice.setCreated_at(created_at);
            }
            if (total != null) {
                invoice.setTotal(total);
            }
            entityManager.merge(invoice);
            entityManager.getTransaction().commit();
        }
        entityManager.close();
    }

    public void Delete(Integer id){
        EntityManager entityManager = GestorGenerico.getEntityManager();
        entityManager.getTransaction().begin();
        Invoice invoice = entityManager.find(Invoice.class, id);
        if (invoice != null)
        { entityManager.remove(invoice);
            entityManager.getTransaction().commit();
        }
        entityManager.close();
    }

}
