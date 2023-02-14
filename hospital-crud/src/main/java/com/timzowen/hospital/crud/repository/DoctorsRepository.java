package com.timzowen.hospital.crud.repository;

import com.timzowen.hospital.crud.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorsRepository extends JpaRepository<Doctor,Long> {
}
