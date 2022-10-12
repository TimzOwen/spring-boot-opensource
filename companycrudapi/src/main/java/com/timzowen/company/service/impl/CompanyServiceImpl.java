package com.timzowen.company.service.impl;

import com.timzowen.company.model.Company;
import com.timzowen.company.repository.CompanyRepository;
import com.timzowen.company.service.CompanyService;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService  {
    private final CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        super();
        this.companyRepository = companyRepository;
    }

    @Override
    public Company saveCompany(Company company) {
        return companyRepository.save(company);
    }
}
