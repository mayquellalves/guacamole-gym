package service;

import java.util.List;

import dao.Dao;
import model.Customer;

public class CustomerService extends Dao<Customer>{
	
	public List<Customer> getAllCustomer() {
		List<Customer> customers = findAll();
		return customers;
	}

	public Customer getEquipment(Long id) {
		return findOne(id);
	}

	public void addCustomer(Customer customer) {
		save(customer);
	}

	public Customer updateCustomer(Customer customer) {
		
		update(customer);
		
		return customer;
	}
	
	 public String deleteEquipment(Long id){
		 remove(id);
	 	
	 return "Removido com Sucesso";
	 }

}
