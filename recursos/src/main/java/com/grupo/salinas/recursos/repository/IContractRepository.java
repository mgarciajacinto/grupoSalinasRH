package com.grupo.salinas.recursos.repository;

import com.grupo.salinas.recursos.models.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IContractRepository extends JpaRepository<Contract,Integer> {
    @Query("SELECT r FROM Contract r where r.employee_id = ?1")
    Contract getContratoByIdEmple(int idEmpl);

    @Query("SELECT r FROM Contract r where r.is_active = ?1 and r.employee_id = ?2")
    Contract getContratoByIsActiveByEm(int isActive,int idEmpl);
}
