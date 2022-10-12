package com.timzowen.company.controller;

import com.timzowen.company.model.Company;
import com.timzowen.company.service.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {

    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        super();
        this.companyService = companyService;
    }

    @PostMapping
    public ResponseEntity<Company> saveCompany(@RequestBody Company company){
        return new ResponseEntity<>(companyService.saveCompany(company), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Company> getAllCompanies(){
        return companyService.getAllCompanies();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompany(@PathVariable("id") long companyId){
        return new ResponseEntity<>(companyService.getCompany(companyId),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Company> updateCompany(@PathVariable("id") long id,
                                                 @RequestBody Company company ){
        return new ResponseEntity<>(companyService.updateCompany(company,id),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable("id") long id){
        companyService.deleteCompany(id);
        return new ResponseEntity<>("company Deleted successfully",HttpStatus.OK);
    }
}
