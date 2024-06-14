package gestores;

import clases.Invoice;
import clases.Products;
import jakarta.persistence.EntityManager;

import java.util.Date;
import java.util.List;

public class GestorProducto {

    public void create(String description, String code, Integer stock, Double price) {
        EntityManager entityManager = GestorGenerico.getEntityManager();
        entityManager.getTransaction().begin();
        Products products  = new Products(description,code,stock,price);
        entityManager.persist(products);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public List<Products> readAll() {
        EntityManager entityManager = GestorGenerico.getEntityManager();
        List<Products> products = entityManager.createQuery("FROM Products", Products.class).getResultList();
        entityManager.close();
        return products;
    }

    public Products readById(Integer id) {
        EntityManager entityManager = GestorGenerico.getEntityManager();
        Products products = entityManager.find(Products.class, id);
        entityManager.close();
        return products;
    }

    public void update(Integer id,String description, String code, Integer stock, Double price) {
        EntityManager entityManager = GestorGenerico.getEntityManager();
        entityManager.getTransaction().begin();
        Products products = entityManager.find(Products.class, id);
        if (products != null) {
            if (description != null) {
                 products.setDescription(description);
            }
            if (code != null) {
                products.setCode(code);
            }
            if (stock != null) {
                products.setStock(stock);
            }
            if (price !=null)
            {
                products.setPrice(price);
            }
            entityManager.merge(products);
            entityManager.getTransaction().commit();
        }
        entityManager.close();
    }

    public void Delete(Integer id){
        EntityManager entityManager = GestorGenerico.getEntityManager();
        entityManager.getTransaction().begin();
        Products products = entityManager.find(Products.class, id);
        if (products != null)
        { entityManager.remove(products);
            entityManager.getTransaction().commit();
        }
        entityManager.close();
    }


}
