package com.SpringBasics.JPA_oneToOne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    public EmployeeRepository repository;

    @GetMapping
    public List<Employee> getAllEmployee(){
        return repository.findAll();
    }

    @PostMapping
    public String insertEmployee(@RequestBody Employee employee){
        repository.save(employee);
        return "Employee added.";
    }

    @PutMapping("/{id}")
    public String updateEmployee(@PathVariable long id,@RequestBody Employee employee){
        Optional<Employee> employee1 = repository.findById(id);
        if (employee1.isPresent()) {
            employee1.get().setName(employee.getName());
            repository.save(employee1.get());
        }
        return "Employee updated.";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable long id){
        repository.deleteById(id);
        return "Employee delete0d.";
    }
}
