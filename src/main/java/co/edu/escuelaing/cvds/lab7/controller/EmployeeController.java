package co.edu.escuelaing.cvds.lab7.controller;


import co.edu.escuelaing.cvds.lab7.model.Employee;

import co.edu.escuelaing.cvds.lab7.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String employees(Model model) {
        List<Employee> employees = employeeService.getEmployees();
        model.addAttribute("trabajadores", employees); 
        return "Employee/employeeList";  
    }
    @GetMapping("/add")
    public String addEmployee() {
        return "Employee/employeeAdd";
    }
    
    @PostMapping("/procesarNuevo")
    public String procesarFormulario(@RequestParam("ID") String id, @RequestParam("FirstName") String firstName,
    		@RequestParam("LastName") String lastName, @RequestParam("Role") String role, @RequestParam("Salary") double salary) {
    	employeeService.addEmployee(new Employee(id,firstName,lastName,role,salary));
    	return "redirect:/employee/list";
    }
    @GetMapping("/update")
    public String updateEmployee(Model model,@RequestParam("ID") String id ) {
        model.addAttribute("trabajador",employeeService.findEmployee(id));
        return "Employee/updateEmployee";
    }
    
    @PostMapping("/procesarActualizado")
    public String procesarActualizacion(@RequestParam("ID") String id, @RequestParam("FirstName") String firstName,
    		@RequestParam("LastName") String lastName, @RequestParam("Role") String role, @RequestParam("Salary") double salary) {
    	employeeService.updateEmployee(id, new Employee(null,firstName,lastName,role,salary));
    	return "redirect:/employee/list";
    }
    
    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("ID") String id) {
        employeeService.deleteEmployee(id);
        return "redirect:/employee/list";
    }
}


