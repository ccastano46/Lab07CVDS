package co.edu.escuelaing.cvds.lab7.service;

import co.edu.escuelaing.cvds.lab7.model.Configuration;
import co.edu.escuelaing.cvds.lab7.model.Employee;
import co.edu.escuelaing.cvds.lab7.repository.ConfigurationRepository;
import co.edu.escuelaing.cvds.lab7.repository.EmployeeRepository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }
}