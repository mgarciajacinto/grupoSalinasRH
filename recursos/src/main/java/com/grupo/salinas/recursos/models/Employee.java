package com.grupo.salinas.recursos.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "EMPLOYEE")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employee_id;
    private String birth_date;
    private String cell_phone;
    private String date_created;
    private String email;
    private int is_active;
    private String last_name;
    private String name;
    private String tax_id_number;
}
