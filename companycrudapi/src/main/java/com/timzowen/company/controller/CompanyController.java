package com.timzowen.company.controller;


import com.timzowen.company.model.Company;
import com.timzowen.company.service.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
