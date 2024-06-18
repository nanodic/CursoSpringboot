package clases;

import gestores.GestorClients;
import gestores.GestorInvoice;
import gestores.GestorInvoiceDetails;
import gestores.GestorProducts;

import java.util.Date;


public class Main {

    public static void main(String[] args) {

        try{
            GestorClients clients = new GestorClients();
            clients.create("Nahuel", "Di Cioocco",35013234);
            clients.create("Daniel","Perez",14013345);
            clients.create("Silvia", "Guzman", 17104234);
            GestorProducts products = new GestorProducts();
            products.create("Mayonesa 500 cc", "111", 15, 650.50);
            products.create("Yerba 1 kilo", "112", 55, 2300.00);
            products.create("Azucar 1 Kilo", "113", 25, 1100.00);
            products.create("Cafe 800gr", "114", 10, 2800.00);

            Date fecha_creacion = new Date();

            GestorInvoice invoice = new GestorInvoice();
            Clients clients1 =  clients.readById(1);
            invoice.create(clients1.getId(),fecha_creacion,0.00);

            Invoice invoice1 = invoice.readById(1);
            Products products1 = products.readById(1);

            GestorInvoiceDetails invoiceDetails = new GestorInvoiceDetails();
            invoiceDetails.create(invoice1.getId(),0,products1.getId(),products1.getPrice());

        }
        catch (Exception exception)
        {
            System.out.println(exception);
        }
    }
}
