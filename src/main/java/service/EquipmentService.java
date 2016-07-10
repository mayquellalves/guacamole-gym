package service;

import java.util.List;

import dao.Dao;
import model.Equipment;

public class EquipmentService extends Dao<Equipment> {

	public List<Equipment> getAllEquipments() {
		List<Equipment> equipments = findAll();
		return equipments;
	}

	public Equipment getEquipment(Long id) {
		return findOne(id);
	}

	public void addEquipment(Equipment equipment) {
		save(equipment);
	}

	public Equipment updateEquipment(Equipment equipment) {
		
		update(equipment);
		return equipment;
	}
	
	 public String deleteEquipment(Long id){
		 remove(id);
	 	
	 return "Removido com Sucesso";
	 }
}
