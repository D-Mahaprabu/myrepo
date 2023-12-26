package com.example.employees.resolver;

import com.example.employees.model.Employees;
import com.example.employees.repository.EmployeesRepository;
import graphql.kickstart.tools.GraphQLResolver;
import org.springframework.beans.factory.annotation.Autowired;

public class EmployeesResolver implements GraphQLResolver<Employees> {
    @Autowired
    private EmployeesRepository employeesRepository;

    public Employees getEmployees( Employees employees){
        return employeesRepository.findById(employees.getEmployeeId()).orElseThrow(null);
    }
}
