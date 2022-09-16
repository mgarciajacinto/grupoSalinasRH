package com.grupo.salinas.recursos.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "CONTRACT")
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int contract_id;
    private String date_created;
    private String date_form;
    private String date_to;
    private int is_active;
    private int salary_per_day;
    private int contract_type_id;
    private int employee_id;

}
