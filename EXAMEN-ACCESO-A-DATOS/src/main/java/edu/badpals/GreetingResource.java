package edu.badpals;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import edu.badpals.dominio.*;

@Path("/")
public class GreetingResource {

    @Inject
    ServiceOlli service;

    @GET
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/wellcome")
    public String wellcome() {
        return "Wellcome Ollivanders!";
    }


    @POST
    @Path("/ordena")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    // curl -d '{"user": {"nombre": "Hermione"}, "item": {"nombre": "AgedBrie"}}' 
    // -H "Content-Type: application/json" -X POST http://localhost:8080/ordena -v
    public Response post(@Valid Order order) {
        Order pedido = service.comanda(order.getWizard().getNombre(), order.getItem().getNombre());
        return pedido != null?
            Response.status(Response.Status.CREATED).entity(pedido).build():
            Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    @Path("/pedidos/{usuaria}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    // curl -w "\n" http://localhost:8080/pedidos/Hermione -v
    public List<Order> list(@PathParam("wizards") String wizards) {
        return service.cargaOrder(wizards);
    }

    @GET
    @Path("/pedidos")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    // curl -w "\n" http://localhost:8080/pedidos -v
    public List<Order> list() {
        return service.orders();
    }

    @GET
    @Path("/item/{nombre}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    // curl -w "\n" http://localhost:8080/item/AgedBrie -v
    public Response gItem(@PathParam("nombre") String nombre) {
        MagicalItem item = service.cargaMagicalItem(nombre);
        return item.getNombre().isEmpty()? 
            Response.status(Response.Status.NOT_FOUND).build():
            Response.status(Response.Status.OK).entity(item).build();
    }


    @DELETE
    @Path("/baja/{wizards}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    // curl -H "Content-Type: application/json" -X DELETE http://localhost:8080/baja/Severus   
    public List<Order> delete(@PathParam("wizards") String nombre) {
        service.eliminaWizards(nombre);
        return service.orders();
    }
}
