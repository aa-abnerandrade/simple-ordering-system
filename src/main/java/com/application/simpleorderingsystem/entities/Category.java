package com.application.simpleorderingsystem.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_category")
public class Category implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
  @Getter
  @Setter
  private Long id;

  @Getter
  @Setter
  private String name;

  @JsonIgnoreProperties("categories")
  @ManyToMany(mappedBy = "categories")
  @Getter
  private Set<Product> products = new HashSet<>();


  public Category() {
  }

  public Category(Long id, String name) {
    super();
    this.id = id;
    this.name = name;
  }


  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    Category category = (Category) o;
    return Objects.equals(id, category.id);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(id);
  }
}
