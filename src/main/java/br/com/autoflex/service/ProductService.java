package br.com.autoflex.service;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import br.com.autoflex.dto.ProductDto;
import br.com.autoflex.entity.Product;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class ProductService implements PanacheRepository<Product> {
  public List<Product> index() {
    return Product.listAll();
  }

  @Transactional
  public Product save(ProductDto dto) {
    Product product = new Product();
    product.setName(dto.getName());
    product.setPrice(dto.getPrice());

    product.persist();

    return product;
  }

  @Transactional
  public Product update(Long id, ProductDto dto) {
    Product product = new Product();

    Optional<Product> productOp = Product.findByIdOptional(id);

    if (productOp.isEmpty()) {
      throw new NullPointerException("Product not found!");
    }

    product = productOp.get();

    product.setName(dto.getName());
    product.setPrice(dto.getPrice());

    return product;
  }

  @Transactional
  public void remove(Long id) {

    Optional<Product> productOp = Product.findByIdOptional(id);

    if (productOp.isEmpty()) {
      throw new NullPointerException("Product not found!");
    }

    Product product = productOp.get();
    product.delete();
  }
}
