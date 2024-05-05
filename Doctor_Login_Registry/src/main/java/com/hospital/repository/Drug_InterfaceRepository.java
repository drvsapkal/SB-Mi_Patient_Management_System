package com.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospital.entity.Drug;

@Repository
public interface Drug_InterfaceRepository extends JpaRepository<Drug, Long>{

}
