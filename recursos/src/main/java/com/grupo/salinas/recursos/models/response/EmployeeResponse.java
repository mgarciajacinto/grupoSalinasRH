package com.grupo.salinas.recursos.models.response;

import lombok.Data;

@Data
public class EmployeeResponse {
    private String fullName;
    private String axIdNumber;
    private String email;
    private String contractName;
    private String dateToContract;
    private String salaryPerDay;

}
