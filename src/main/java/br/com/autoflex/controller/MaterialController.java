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

import br.com.autoflex.dto.MaterialDto;
import br.com.autoflex.entity.Material;
import br.com.autoflex.service.MaterialService;

@Path("materials")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MaterialController {
  @Inject
  MaterialService service;

  @GET
  public Response index() {
    List<Material> materials = service.index();
    return Response.ok(materials).build();
  }

  @POST
  public Response save(MaterialDto dto) {
    Material material = service.save(dto);

    return Response.ok(material).status(Response.Status.CREATED).build();
  }

  @PUT
  @Path("{id}")
  public Response update(@PathParam("id") Long id, MaterialDto dto) {
    Material material = service.update(id, dto);

    return Response.ok(material).status(Response.Status.CREATED).build();
  }

  @DELETE
  @Path("{id}")
  public Response remove(@PathParam("id") Long id) {
    service.remove(id);

    return Response.status(204).build();
  }
}
