package test.service;

import java.util.List;

import test.dao.Dao;
import test.model.Address;

public class AddressService extends Dao<Address> {

	public List<Address> getAllAddresss() {
		List<Address> addresss = findAll();
		return addresss;
	}

	public Address getAddress(Long id) {
		return findOne(id);
	}

	public void addAddress(Address address) {
		save(address);
	}

	public Address updateAddress(Address address) {

		update(address);
		
		return address;
	}

	public String deleteAddress(Long id) {
		remove(id);

		return "Removido com Sucesso";
	}
}
