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
    public void EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/example")
    public String example(Model model) {
        model.addAttribute("premio", configurationService.getPremio());
        return "example";
    }

    @GetMapping("/example/api")
    public String exampleApi() {
        return "example-api";
    }

    @GetMapping("/example/api/configurations")
    @ResponseBody
    public List<Configuration> exampleApiConfigurations() {
        return configurationService.getAllConfigurations();
    }

    @PostMapping("/example/api/configurations")
    @ResponseBody
    public List<Configuration> exampleApiConfigurations(@RequestBody Configuration configuration) {
        configurationService.addConfiguration(configuration);
        return configurationService.getAllConfigurations();
    }
}

