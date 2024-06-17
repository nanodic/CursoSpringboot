package clases;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class InvoiceDetails {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer invoce_detail_id;

    @Column
    private Integer invoice_id;
    @Column
    private Integer amount;
    @Column
    private Integer product_id;
    @Column
    private Double price;


    @ManyToOne()
    @JoinColumn(name = "invoice_id")
    private Invoice invoice;

    @ManyToOne()
    @JoinColumn(name = "product_id")
    private Products product;


    public InvoiceDetails(Integer invoice_id, Integer amount, Integer product_id, Double price) {
        this.invoice_id = invoice_id;
        this.amount = amount;
        this.product_id = product_id;
        this.price = price;
    }

    public Integer getInvoce_detail_id() {
        return invoce_detail_id;
    }

    public void setInvoce_detail_id(Integer invoce_detail_id) {
        this.invoce_detail_id = invoce_detail_id;
    }

    public Integer getInvoice_id() {
        return invoice_id;
    }

    public void setInvoice_id(Integer invoice_id) {
        this.invoice_id = invoice_id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceDetails that = (InvoiceDetails) o;
        return Objects.equals(invoce_detail_id, that.invoce_detail_id) && Objects.equals(invoice_id, that.invoice_id) && Objects.equals(amount, that.amount) && Objects.equals(product_id, that.product_id) && Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(invoce_detail_id, invoice_id, amount, product_id, price);
    }

    @Override
    public String toString() {
        return "InvoiceDetails{" +
                "invoce_detail_id=" + invoce_detail_id +
                ", invoice_id=" + invoice_id +
                ", amount=" + amount +
                ", product_id=" + product_id +
                ", price=" + price +
                '}';
    }
}
