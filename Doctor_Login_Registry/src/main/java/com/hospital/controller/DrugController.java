package com.hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.entity.Drug;
import com.hospital.response_result.ResponseResult;
import com.hospital.service.Drug_InterfaceService;

@RestController
@CrossOrigin("*")
@RequestMapping("/drug")
public class DrugController {

	@Autowired
	Drug_InterfaceService drug_InterfaceService;
	
	@PostMapping("/addPatientDrug")
	private ResponseEntity<ResponseResult> addDrugs(@RequestBody Drug drug) {
		
		boolean addedMedicines = drug_InterfaceService.addDrugs(drug);
		String message = addedMedicines ? "Added Medicine to Patient" : "Please Enter Valid Medicine";
		ResponseResult response = new ResponseResult(addedMedicines, message);
		HttpStatus status = addedMedicines ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
		return new ResponseEntity<ResponseResult>(response, status);
	
	}	
}
