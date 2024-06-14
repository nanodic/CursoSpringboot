package gestores;

import clases.InvoiceDetails;
import clases.Products;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;

public class GestorInvoiceDetails {

    public void create(Integer invoice_id, Integer amount, Integer product_id, Double price) {
        EntityManager entityManager = GestorGenerico.getEntityManager();
        entityManager.getTransaction().begin();
        InvoiceDetails invoiceDetails  = new InvoiceDetails(invoice_id,amount,product_id,price);
        entityManager.persist(invoiceDetails);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public List<InvoiceDetails> readAll() {
        EntityManager entityManager = GestorGenerico.getEntityManager();
        List<InvoiceDetails> invoiceDetails = entityManager.createQuery("FROM InvoiceDetails", InvoiceDetails.class).getResultList();
        entityManager.close();
        return invoiceDetails;
    }

    public InvoiceDetails readById(Integer invoice_detail_id) {
        EntityManager entityManager = GestorGenerico.getEntityManager();
        InvoiceDetails invoiceDetails = entityManager.find(InvoiceDetails.class, invoice_detail_id);
        entityManager.close();
        return invoiceDetails;
    }

    public void update(Integer invoice_detail_id ,Integer invoice_id, Integer amount, Integer product_id, Double price) {
        EntityManager entityManager = GestorGenerico.getEntityManager();
        entityManager.getTransaction().begin();
        InvoiceDetails invoiceDetails = entityManager.find(InvoiceDetails.class, invoice_detail_id);
        if (invoiceDetails != null) {
            if (invoice_id != null) {
                invoiceDetails.setInvoice_id(invoice_id);
            }
            if (amount != null) {
                invoiceDetails.setAmount(amount);
            }
            if (product_id != null) {
                invoiceDetails.setProduct_id(product_id);
            }
            if (price !=null)
            {
                invoiceDetails.setPrice(price);
            }
            entityManager.merge(invoiceDetails);
            entityManager.getTransaction().commit();
        }
        entityManager.close();
    }

    public void Delete(Integer invoice_detail_id){
        EntityManager entityManager = GestorGenerico.getEntityManager();
        entityManager.getTransaction().begin();
        InvoiceDetails invoiceDetails = entityManager.find(InvoiceDetails.class,invoice_detail_id);
        if (invoiceDetails != null)
        { entityManager.remove(invoice_detail_id);
            entityManager.getTransaction().commit();
        }
        entityManager.close();
    }


}
