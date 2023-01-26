package br.com.autoflex;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

public class Product extends PanacheEntity {
  private String name;
  private Double price;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }
}
