package br.com.autoflex.dto;

public class MaterialDto {
  private String name;
  private Long stock;

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
}
