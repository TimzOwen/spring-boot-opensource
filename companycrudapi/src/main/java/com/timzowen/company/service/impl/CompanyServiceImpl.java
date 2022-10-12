package com.timzowen.company.service.impl;

import com.timzowen.company.exception.ResourceNotFoundException;
import com.timzowen.company.model.Company;
import com.timzowen.company.repository.CompanyRepository;
import com.timzowen.company.service.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Company getCompany(long id) {
        return companyRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Company","ID",id));
    }

    @Override
    public Company updateCompany(Company company, long id) {
        Company existingCompany = companyRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("%s Nof found ","Id",id));
        existingCompany.setLocation(company.getLocation());
        existingCompany.setName(company.getName());
        existingCompany.setNetWorth(company.getNetWorth());
        companyRepository.save(existingCompany);
        return existingCompany;
    }

    @Override
    public void deleteCompany(long id) {
        companyRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("%s Not found","id",id));
        companyRepository.deleteById(id);
    }

}
