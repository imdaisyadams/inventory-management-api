package entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Set;

@Entity
public class Product {
    private Long id;
    private String name;
    private String description;
    private double price;

    @JsonIgnore
    private Set<Order> orders;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "product_order",
        joinColumns = @JoinColumns(name = "orderId", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumns(name = "productId", referencedColumnName = "id"))
    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

}
