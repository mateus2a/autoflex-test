package br.com.autoflex.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
@Table(name = "materials")
public class Material extends PanacheEntity {
  private String name;
  private Long stock;

  @OneToMany(mappedBy = "material")
  Set<ProductMaterial> materials;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getStock() {
    return stock;
  }

  public void setStock(Long stock) {
    this.stock = stock;
  }

  public Set<ProductMaterial> getMaterials() {
    return materials;
  }

  public void setMaterials(Set<ProductMaterial> materials) {
    this.materials = materials;
  }
}
