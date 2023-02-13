package com.example.demo.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.com.Model;
import com.example.demo.repo.EmployeeRepo;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Model addEmployee(Model employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }

    public List<Model> findAllEmployees() {
        return employeeRepo.findAll();
    }

    public Model updateEmployee(Model employee) {
        return employeeRepo.save(employee);
    }
    public Model findEmployeeByID(Long ID){
        return
                employeeRepo
                        .findEmployeeById(ID)
                        .orElseThrow(()-> new UserNotFoundException("User by ID" + ID +"Wasnt found"));

    }

    public void  deleteEmployee(Long ID) {
        employeeRepo.deleteEmployeeById(ID);
    }
}
