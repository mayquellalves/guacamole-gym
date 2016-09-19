package test.controller;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import test.model.Customer;
import test.service.CustomerService;

@Path("/customer")
public class CustomerController {

	CustomerService service = new CustomerService();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Customer> getAllCustomer() {
		return service.getAllCustomer();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path(value = "{id}")
	public Customer getCustomer(@PathParam("id") Long id) {
		return service.findOne(id);
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response addCustomer(Customer customer) {
		service.addCustomer(customer);

		return Response.status(201).entity(customer).build();
	}
	
	public Response updateCustomer(Customer customer){
		
		service.updateCustomer(customer);
		
		return Response.status(200).entity(customer).build();
	}
	
}
