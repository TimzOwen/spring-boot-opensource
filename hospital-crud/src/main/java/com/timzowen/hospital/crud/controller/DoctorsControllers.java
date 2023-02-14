package com.timzowen.hospital.crud.controller;

import com.timzowen.hospital.crud.entity.Doctor;
import com.timzowen.hospital.crud.exception.ResourceNotFound;
import com.timzowen.hospital.crud.repository.DoctorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorsControllers {

    @Autowired
    private DoctorsRepository doctorsRepository;

    // find all doctors
    @GetMapping()
    public List<Doctor> getAllDoctors(){
        return doctorsRepository.findAll();
    }

    //create doctor
    @PostMapping
    public Doctor createDoctor(@RequestBody Doctor doctor){
        return doctorsRepository.save(doctor);
    }
    //Get Doctor by Id
    @GetMapping("{id}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable long id){
        Doctor doctor=  doctorsRepository.findById(id).orElseThrow(()->
                new ResourceNotFound("Not found " + id));
        return ResponseEntity.ok(doctor);
    }

    //update doctors
    @PutMapping("{id}")
    public ResponseEntity<Doctor> updateDoctors(@PathVariable long id, @RequestBody Doctor doctor){
        Doctor updateDoc = doctorsRepository.findById(id).orElseThrow(()->
                new ResourceNotFound("No such doctor"));
        updateDoc.setFirstName(doctor.getFirstName());
        updateDoc.setLastName(doctor.getLastName());
        updateDoc.setEmail(doctor.getEmail());
        doctorsRepository.save(doctor);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // delete all Doctor
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id){
        Doctor doctor = doctorsRepository.findById(id).orElseThrow(()->
                new ResourceNotFound("Not found " + id));
        doctorsRepository.delete(doctor);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
