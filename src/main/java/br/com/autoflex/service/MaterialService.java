package br.com.autoflex.service;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import br.com.autoflex.dto.MaterialDto;
import br.com.autoflex.entity.Material;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class MaterialService implements PanacheRepository<Material> {
  public List<Material> index() {
    return Material.listAll();
  }

  @Transactional
  public Material save(MaterialDto dto) {
    Material material = new Material();
    material.setName(dto.getName());
    material.setStock(dto.getStock());

    material.persist();

    return material;
  }

  @Transactional
  public Material update(Long id, MaterialDto dto) {
    Material material = new Material();

    Optional<Material> materialOp = Material.findByIdOptional(id);

    if (materialOp.isEmpty()) {
      throw new NullPointerException("Material not found!");
    }

    material = materialOp.get();

    material.setName(dto.getName());
    material.setStock(dto.getStock());

    material.persist();

    return material;
  }

  @Transactional
  public void remove(Long id) {

    Optional<Material> materialOp = Material.findByIdOptional(id);

    if (materialOp.isEmpty()) {
      throw new NullPointerException("Material not found!");
    }

    Material material = materialOp.get();
    material.delete();
  }
}
