package com.application.simpleorderingsystem.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_product")
public class Product implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Getter
  @Setter
  private Long id;

  @Getter
  @Setter
  private String name;

  @Getter
  @Setter
  private String description;

  @Getter
  @Setter
  private Double price;

  @Getter
  @Setter
  private String imageUrl;

  private List<Order> orders;

  @ManyToMany
  @Getter
  @JsonIgnoreProperties("products")
  @JoinTable(name = "tb_product_category",
          joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
  private Set<Category> categories = new HashSet<>();

  @OneToMany(mappedBy = "id.product")
  private Set<OrderItem> items = new HashSet<>();


  public Product() {
  }

  public Product(Long id, String name, String description, Double price, String imageUrl) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.price = price;
    this.imageUrl = imageUrl;
  }


  @JsonIgnore
  public Set<Order> getOrders() {
    Set<Order> set = new HashSet<>();
    for (OrderItem item : items) {
      set.add(item.getOrder());
    }
    return set;
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    Product product = (Product) o;
    return Objects.equals(id, product.id) && Objects.equals(name, product.name) && Objects.equals(description, product.description) && Objects.equals(price, product.price);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, description, price);
  }
}
