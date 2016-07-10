package service;

import java.util.List;

import dao.Dao;
import model.Customer;
import model.Equipment;

public class CustomerService extends Dao<Customer>{
	
	public List<Customer> getAllEquipments() {
		List<Customer> customers = findAll();
		return customers;
	}

	public Customer getEquipment(Long id) {
		return findOne(id);
	}

	public void addEquipment(Customer customer) {
		save(customer);
	}

	public Customer updateEquipment(Customer customer) {
		
		update(customer);
		
		return customer;
	}
	
	 public String deleteEquipment(Long id){
		 remove(id);
	 	
	 return "Removido com Sucesso";
	 }

}
