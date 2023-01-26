package br.com.autoflex.dto;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.autoflex.entity.Material;
import br.com.autoflex.entity.Product;

public class ProductMaterialDto {
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
