package com.example.demo.resources;

import com.example.demo.com.Model;
import com.example.demo.services.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeResourse {
    private final EmployeeService employeeService;

    public EmployeeResourse(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<Model>> GetAllEmployees (){
        List<Model>employees = employeeService.findAllEmployees();
        return  new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Model> GetEmployeeById (@PathVariable("id") Long id){
        Model employee = employeeService.findEmployeeByID(id);
        return  new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping("/add")

    public  ResponseEntity<Model> addEmployee(@RequestBody Model employee){
        Model newEmployee = employeeService.addEmployee(employee);
        return  new ResponseEntity<>(newEmployee,HttpStatus.CREATED);
    }

    @PutMapping("/update")

    public  ResponseEntity<Model> updateEmployee(@RequestBody Model employee){
        Model updateEmployee = employeeService.updateEmployee(employee);
        return  new ResponseEntity<>(updateEmployee,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @Transactional
    public  ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id){
        employeeService.deleteEmployee(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }




}
