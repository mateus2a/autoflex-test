package br.com.autoflex.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
@Table(name = "products_materials")
public class ProductMaterial extends PanacheEntity {
  @ManyToOne
  @JoinColumn(name = "product_id")
  Product product;

  @ManyToOne
  @JoinColumn(name = "material_id")
  Material material;

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public Material getMaterial() {
    return material;
  }

  public void setMaterial(Material material) {
    this.material = material;
  }
}
