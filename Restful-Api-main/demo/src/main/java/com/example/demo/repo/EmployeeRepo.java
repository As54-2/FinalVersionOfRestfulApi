package com.example.demo.repo;
import com.example.demo.com.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Model, Long> {
    void deleteEmployeeById(Long id);

    Optional<Model> findEmployeeById(Long id);
}
