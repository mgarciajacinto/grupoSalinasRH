package com.grupo.salinas.recursos.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "CONTRACT_TYPE")
public class ContractType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int contract_type_id;
    private String date_create;
    private String description;
    private int is_active;
    private String name;

}
