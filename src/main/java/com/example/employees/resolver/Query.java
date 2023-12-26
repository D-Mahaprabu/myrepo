package com.example.employees.resolver;

import com.example.employees.model.Employees;
import com.example.employees.repository.EmployeesRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
@Component
public class Query implements GraphQLQueryResolver {
    @Autowired
    private EmployeesRepository employeesRepository;
    public List<Employees> getAllEmployees(){
        return employeesRepository.findAll();
    }


}
