package com.application.simpleorderingsystem.entities;

import com.application.simpleorderingsystem.entities.pk.OrderItemPK;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  @EmbeddedId
  private OrderItemPK id = new OrderItemPK();

  @Getter
  @Setter
  private Integer quantity;

  @Getter
  @Setter
  private Double price;


  public OrderItem() {
  }

  public OrderItem(Order order, Product product, Integer quantity, Double price) {
    super();
    this.id.setOrder(order);
    this.id.setProduct(product);
    this.quantity = quantity;
    this.price = price;
  }


  @JsonIgnore
  public Order getOrder() {
    return this.id.getOrder();
  }

  public void setOrder(Order order) {
    this.id.setOrder(order);
  }

  public Product getProduct() {
    return this.id.getProduct();
  }

  public void setProduct(Product product) {
    this.id.setProduct(product);
  }


  public Double getSubTotal() {
    return price * quantity;
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof OrderItem orderItem)) return false;
    return Objects.equals(id, orderItem.id);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(id);
  }
}
