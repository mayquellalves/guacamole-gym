package service;

import java.util.List;

import dao.Dao;
import model.Address;

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
