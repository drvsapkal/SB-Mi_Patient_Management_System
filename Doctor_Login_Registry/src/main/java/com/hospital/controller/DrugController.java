package com.hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.entity.Drug;
import com.hospital.service.Drug_InterfaceService;

@RestController
@RequestMapping("/drug")
public class DrugController {

	@Autowired
	Drug_InterfaceService drug_InterfaceService;
	
	@PostMapping("/addPatientDrug")
	private ResponseEntity<Drug> addDrugs(@RequestBody Drug drug) {
		
		if(drug_InterfaceService.addDrugs(drug))
		{
			return new ResponseEntity<Drug>(HttpStatusCode.valueOf(200));
		}
		else {
			return new ResponseEntity<Drug>(HttpStatusCode.valueOf(401));
		}
	}
	
}
