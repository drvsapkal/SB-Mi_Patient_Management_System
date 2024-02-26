package com.patient.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.patient.entity.Doctor;

@Repository
public interface Doctor_InterfaceRepository extends JpaRepository<Doctor, Long>{

}
