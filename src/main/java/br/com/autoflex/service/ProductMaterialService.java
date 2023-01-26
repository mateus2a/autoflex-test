package br.com.autoflex.service;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import br.com.autoflex.dto.ProductMaterialDto;
import br.com.autoflex.entity.ProductMaterial;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class ProductMaterialService implements PanacheRepository<ProductMaterial> {
  public List<ProductMaterial> index() {
    return ProductMaterial.listAll();
  }

  @Transactional
  public ProductMaterial save(ProductMaterialDto dto) {
    ProductMaterial productMaterial = new ProductMaterial();
    productMaterial.setProduct(dto.getProduct());
    productMaterial.setMaterial(dto.getMaterial());

    productMaterial.persist();

    return productMaterial;
  }

  @Transactional
  public ProductMaterial update(Long id, ProductMaterialDto dto) {
    ProductMaterial productMaterial = new ProductMaterial();

    Optional<ProductMaterial> productMaterialOp = ProductMaterial.findByIdOptional(id);

    if (productMaterialOp.isEmpty()) {
      throw new NullPointerException("Product not found!");
    }

    productMaterial = productMaterialOp.get();

    productMaterial.setProduct(dto.getProduct());
    productMaterial.setMaterial(dto.getMaterial());

    return productMaterial;
  }

  @Transactional
  public void remove(Long id) {

    Optional<ProductMaterial> productMaterialOp = ProductMaterial.findByIdOptional(id);

    if (productMaterialOp.isEmpty()) {
      throw new NullPointerException("Product not found!");
    }

    ProductMaterial productMaterial = productMaterialOp.get();
    productMaterial.delete();
  }
}
