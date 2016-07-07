package service;

import java.util.List;

import dao.Dao;
import model.Equipment;

public class EquipmentService {

	private Dao dao = new Dao();

	public List<Equipment> getAllEquipments() {
		List<Equipment> equipments = dao.findAllEquipment();
		return equipments;
	}
	
	public Equipment getEquipment(Long id) {
		return dao.findOne(id);
	}

	public Equipment addEquipment(Equipment equipment) {
		dao.save(equipment);
		return equipment;
	}
	
	public String deleteEquipment(Long id){
		return dao.delete(id);
	}
}
