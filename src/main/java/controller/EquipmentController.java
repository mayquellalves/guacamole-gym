package controller;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.Equipment;
import service.EquipmentService;

@Path("/equipment")
public class EquipmentController {

	EquipmentService eService = new EquipmentService();

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayPlainTextHello() {
		return "Hello Jersey";
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path(value = "/getAllEquipment")
	public List<Equipment> getAllEquipment() {

		List<Equipment> equipments = eService.getAllEquipments();
		return equipments;
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path(value = "/addEquipment")
	public Equipment addEquipment(Equipment equipment) {
		return eService.addEquipment(equipment);
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path(value = "/updateEquipment")
	public String updateEquipment(Equipment equipment) {
		eService.addEquipment(equipment);

		return "Equipment update with Sucess";
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path(value = "/deleteEquipment")
	public String deleteEquipment(Equipment equipment) {
		return eService.deleteEquipment(equipment);
	}

}
