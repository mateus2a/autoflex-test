package br.com.autoflex.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
@Table(name = "materials")
public class Material extends PanacheEntity {
  private String name;
  private Double stock;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Double getStock() {
    return stock;
  }

  public void setStock(Double stock) {
    this.stock = stock;
  }
}
