package com.application.simpleorderingsystem.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;


@Entity
@Table(name = "tb_payment")
public class Payment implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Getter
  @Setter
  private Long id;

  @Getter
  @Setter
  private Instant moment;

  @OneToOne
  @MapsId
  @JsonIgnore
  @Getter
  @Setter
  private Order order;

  public Payment() {
  }

  public Payment(Long id, Instant moment, Order order) {
    this.id = id;
    this.moment = moment;
    this.order = order;
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof Payment payment)) return false;
    return Objects.equals(id, payment.id) && Objects.equals(moment, payment.moment) && Objects.equals(order, payment.order);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, moment, order);
  }
}
