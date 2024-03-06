package com.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospital.entity.Doctor;

@Repository
public interface Doctor_InterfaceRepository extends JpaRepository<Doctor, Long>{
	
	Doctor findByUserName(String userName);
}
