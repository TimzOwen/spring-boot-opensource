package com.timzowen.hospital.crud.service.impl;

import com.timzowen.hospital.crud.entity.Doctor;
import com.timzowen.hospital.crud.repository.DoctorsRepository;
import com.timzowen.hospital.crud.service.DoctorsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorsServiceImpl implements DoctorsService {
    DoctorsRepository doctorsRepository;

    public DoctorsServiceImpl(DoctorsRepository doctorsRepository){
        super();
        this.doctorsRepository = doctorsRepository;
    }

    public List<Doctor> getAllDoctors(){
        return doctorsRepository.findAll();
    }

}
