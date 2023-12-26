package com.example.employees.resolver;

import com.example.employees.model.Employees;
import com.example.employees.repository.EmployeesRepository;
import graphql.kickstart.tools.GraphQLMutationResolver;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public class Mutation implements GraphQLMutationResolver {
    @Autowired
    private EmployeesRepository employeesRepository;

    public Employees createEmployee(String employeeName,Integer employeeAge,String employeeAddress,Long employeeContact){
        Employees employees = new Employees();
        employees.setEmployeeName(employeeName);
        employees.setEmployeeAge(employeeAge);
        employees.setEmployeeAddress(employeeAddress);
        employees.setEmployeeContact(employeeContact);
        try {
            employeesRepository.save(employees);
            return employees;
        } catch (Exception e){
         throw new RuntimeException("failed to create new record" , e);
        }
    }
    public boolean deleteEmployee(Long employeeId){
        employeesRepository.deleteById(employeeId);
        return true ;
    }

    public Employees updateEmployee(Long employeeId,String employeeName,Integer employeeAge,String employeeAddress,Long employeeContact)
            throws EntityNotFoundException {
        Optional<Employees> optionalEmployees = employeesRepository.findById(employeeId);
        if(optionalEmployees.isPresent()){
            Employees employees = optionalEmployees.get();
            employees.setEmployeeName(employeeName);
            employees.setEmployeeAge(employeeAge);
            employees.setEmployeeAddress(employeeAddress);
            employees.setEmployeeContact(employeeContact);
            employeesRepository.save(employees);
            return employees;
        }else {
            throw new EntityNotFoundException("No such employee to update ");
        }
    }
}
