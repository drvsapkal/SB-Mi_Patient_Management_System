package com.hospital.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.entity.Drug;
import com.hospital.repository.Drug_InterfaceRepository;

@Service
public class DrugService implements Drug_InterfaceService{
	
	@Autowired
	Drug_InterfaceRepository drug_InterfaceRepository;

	@Override
	public boolean addDrugs(Drug drug) {
		
		Drug drugResponse = drug_InterfaceRepository.save(drug);
		
		if(drugResponse != null)
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	
}
