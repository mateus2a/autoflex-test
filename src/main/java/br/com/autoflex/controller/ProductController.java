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

import br.com.autoflex.dto.ProductDto;
import br.com.autoflex.entity.Product;
import br.com.autoflex.service.ProductService;

@Path("products")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProductController {
  @Inject
  ProductService service;

  @GET
  public Response index() {
    List<Product> products = service.index();
    return Response.ok(products).build();
  }

  @POST
  public Response save(ProductDto dto) {
    Product product = service.save(dto);

    return Response.ok(product).status(Response.Status.CREATED).build();
  }

  @PUT
  @Path("{id}")
  public Response update(@PathParam("id") Long id, ProductDto dto) {
    Product product = service.update(id, dto);

    return Response.ok(product).status(Response.Status.CREATED).build();
  }

  @DELETE
  @Path("{id}")
  public Response remove(@PathParam("id") Long id) {
    service.remove(id);

    return Response.status(204).build();
  }
}
