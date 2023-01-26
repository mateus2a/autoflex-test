package br.com.autoflex.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
@Table(name = "products")
public class Product extends PanacheEntity {
  private String name;
  private Double price;

  @OneToMany(mappedBy = "product")
  Set<ProductMaterial> products;

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

  public Set<ProductMaterial> getProducts() {
    return products;
  }

  public void setProducts(Set<ProductMaterial> products) {
    this.products = products;
  }
}
