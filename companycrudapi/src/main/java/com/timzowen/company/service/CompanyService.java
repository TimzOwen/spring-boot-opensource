package com.timzowen.company.service;

import com.timzowen.company.model.Company;
import com.timzowen.company.repository.CompanyRepository;

import java.util.List;

public interface CompanyService {

    // Save companies to the database
    Company saveCompany(Company company);

    // Get all companies
    List<Company> getAllCompanies();

    Company getCompany(long id);

    Company updateCompany(Company company, long id);

    void deleteCompany(long id);

}
