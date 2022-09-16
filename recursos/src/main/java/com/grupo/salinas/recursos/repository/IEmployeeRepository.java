package com.grupo.salinas.recursos.repository;

import com.grupo.salinas.recursos.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query("SELECT r FROM Employee r where r.tax_id_number = ?1")
    Employee getByRFC(String rfc);
}
