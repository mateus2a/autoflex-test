package br.com.autoflex.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import br.com.autoflex.entity.Product;

@ApplicationScoped
public class ProductService {
  public List<Product> listProduct() {
    return Product.listAll();
  }
}
