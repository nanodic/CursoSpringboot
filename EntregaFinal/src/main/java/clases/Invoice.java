package clases;

import jakarta.persistence.*;
import org.hibernate.dialect.function.TruncFunction;

import java.util.Date;
import java.util.Objects;

@Entity
public class Invoice {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Integer clientId;
    @Column
    private Date created_at;
    @Column
    private Double total;

    public Invoice(Integer clientId, Date created_at, Double total) {
        this.clientId = clientId;
        this.created_at = created_at;
        this.total = total;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return Objects.equals(id, invoice.id) && Objects.equals(clientId, invoice.clientId) && Objects.equals(created_at, invoice.created_at) && Objects.equals(total, invoice.total);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, clientId, created_at, total);
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", clientId=" + clientId +
                ", created_at=" + created_at +
                ", total=" + total +
                '}';
    }
}
