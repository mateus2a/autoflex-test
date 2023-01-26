package br.com.autoflex.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import br.com.autoflex.dto.ProductDto;
import br.com.autoflex.entity.Product;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class ProductService implements PanacheRepository<Product> {
  public List<Product> listProduct() {
    return Product.listAll();
  }

  @Transactional
  public Product saveProduct(ProductDto dto) {
    Product product = new Product();
    product.setName(dto.getName());
    product.setPrice(dto.getPrice());

    product.persist();

    return product;
  }
}
