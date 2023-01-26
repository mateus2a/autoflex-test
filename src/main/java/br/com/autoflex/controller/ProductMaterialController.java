package br.com.autoflex.controller;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.autoflex.dto.ProductMaterialDto;
import br.com.autoflex.entity.ProductMaterial;
import br.com.autoflex.service.ProductMaterialService;

@Path("products_materials")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProductMaterialController {
  @Inject
  ProductMaterialService service;

  @GET
  public Response index() {
    List<ProductMaterial> productMaterial = service.index();
    return Response.ok(productMaterial).build();
  }

  @POST
  public Response save(ProductMaterialDto dto) {
    ProductMaterial productMaterial = service.save(dto);

    return Response.ok(productMaterial).status(Response.Status.CREATED).build();
  }

  @PUT
  @Path("{id}")
  public Response update(@PathParam("id") Long id, ProductMaterialDto dto) {
    ProductMaterial productMaterial = service.update(id, dto);

    return Response.ok(productMaterial).status(Response.Status.CREATED).build();
  }

  @DELETE
  @Path("{id}")
  public Response remove(@PathParam("id") Long id) {
    service.remove(id);

    return Response.status(204).build();
  }
}
