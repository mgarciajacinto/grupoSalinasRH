package com.grupo.salinas.recursos.controller;

import com.grupo.salinas.recursos.models.Contract;
import com.grupo.salinas.recursos.models.Employee;
import com.grupo.salinas.recursos.models.response.EmployeeResponse;
import com.grupo.salinas.recursos.models.response.ResposeOperacion;
import com.grupo.salinas.recursos.service.IContractEmpleService;
import com.grupo.salinas.recursos.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/exam")
public class ExamenController {
    @Autowired
    IEmployeeService serviceEmpl;
    @Autowired
    IContractEmpleService serviceEmplCon;

    @GetMapping(value = "/empleados", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ArrayList<EmployeeResponse> getEmpleados() {
        return serviceEmpl.getEmpleados();
    }

    @PostMapping(value = "/empleado/contrato", produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResposeOperacion guardaContrato(@RequestBody Contract contrato) {
        return serviceEmplCon.guardaContEmplo(contrato);
    }

    @PostMapping(value = "/empleados", produces = {MediaType.APPLICATION_JSON_VALUE},consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResposeOperacion guardaEmpleados(@RequestBody Employee employee) {
        return serviceEmpl.guardaEmpleado(employee);
    }

    @PutMapping(value = "/empleado/{id}",produces = {MediaType.APPLICATION_JSON_VALUE})
    public  ResposeOperacion modificaEmpleado (@PathVariable int id,@RequestBody Employee employee){
        return serviceEmpl.modificaEmpleado(id,employee);
    }

    @DeleteMapping(value = "/empleado/{id}/contrato/",produces = {MediaType.APPLICATION_JSON_VALUE})
    public  ResposeOperacion eliminaContrato (@PathVariable int id){
        return serviceEmplCon.eliminaContrato(id);
    }
}

