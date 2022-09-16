package com.grupo.salinas.recursos.service;

import com.grupo.salinas.recursos.models.Contract;
import com.grupo.salinas.recursos.models.Employee;
import com.grupo.salinas.recursos.models.response.ResposeOperacion;

public interface IContractEmpleService {
    ResposeOperacion guardaContEmplo(Contract contract);
    ResposeOperacion eliminaContrato(int id);

}
