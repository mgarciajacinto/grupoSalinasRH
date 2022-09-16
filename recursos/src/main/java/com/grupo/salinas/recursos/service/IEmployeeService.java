package com.grupo.salinas.recursos.service;

import com.grupo.salinas.recursos.models.Employee;
import com.grupo.salinas.recursos.models.response.EmployeeResponse;
import com.grupo.salinas.recursos.models.response.ResposeOperacion;

import java.util.ArrayList;

public interface IEmployeeService {
    ArrayList<EmployeeResponse> getEmpleados();
    ResposeOperacion guardaEmpleado(Employee employee);

    ResposeOperacion modificaEmpleado(int id,Employee employee);
}
