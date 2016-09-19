package test.controller;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import test.model.Equipment;
import test.service.EquipmentService;

@Path("/equipment")
public class EquipmentController {

	EquipmentService eService = new EquipmentService();

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Equipment> getAllEquipment() {

		List<Equipment> equipments = eService.getAllEquipments();
		return equipments;
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path(value = "{id}")
	public Equipment getEquipment(@PathParam("id") Long id) {
		return eService.getEquipment(id);
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response addEquipment(Equipment equipment) {

		eService.addEquipment(equipment);

		return Response.status(201).entity(equipment).build();
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateEquipment(Equipment equipment) {
		eService.update(equipment);

		return Response.status(200).entity(equipment).build();
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public String deleteEquipment(@PathParam("id") Long id) {
		return eService.deleteEquipment(id);
	}

}
