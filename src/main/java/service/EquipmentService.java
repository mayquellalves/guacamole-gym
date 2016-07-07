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

	public Equipment addEquipment(Equipment equipment) {
		dao.save(equipment);
		return equipment;
	}
	
	public String deleteEquipment(Equipment equipment){
		return dao.delete(equipment);
	}
}
