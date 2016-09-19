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

import test.model.Address;
import test.service.AddressService;

@Path("/address")
public class AddressController {

	AddressService eService = new AddressService();

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Address> getAllAddress() {

		List<Address> addresss = eService.getAllAddresss();
		return addresss;
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path(value = "{id}")
	public Address getAddress(@PathParam("id") Long id) {
		return eService.getAddress(id);
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response addAddress(Address address) {

		eService.addAddress(address);

		return Response.status(201).entity(address).build();
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateAddress(Address address) {
		eService.update(address);

		return Response.status(200).entity(address).build();
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public String deleteAddress(@PathParam("id") Long id) {
		return eService.deleteAddress(id);
	}

}
