package com.timzowen.company.service;

import com.timzowen.company.model.Company;
import com.timzowen.company.repository.CompanyRepository;

public interface CompanyService {

    Company saveCompany(Company company);

}
