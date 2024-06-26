package co.edu.escuelaing.cvds.lab7.service;

import co.edu.escuelaing.cvds.lab7.model.Configuration;
import co.edu.escuelaing.cvds.lab7.model.Employee;
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
    
    public Employee findEmployee(String id) {
    	return employeeRepository.getReferenceById(id);
    }
    
    
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

   
    public Employee updateEmployee(String id,Employee newEmployee) {
    	Employee existingEmployee= this.findEmployee(id);
        existingEmployee.setFirstName(newEmployee.getFirstName());
        existingEmployee.setLastName(newEmployee.getLastName());
        existingEmployee.setRole(newEmployee.getRole());
        existingEmployee.setSalary(newEmployee.getSalary());
        return employeeRepository.save(existingEmployee);
    }

    
    public void deleteEmployee(String id) {
        employeeRepository.deleteById(id);
    }
}
