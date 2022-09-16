package com.grupo.salinas.recursos.service;

import com.grupo.salinas.recursos.models.Contract;
import com.grupo.salinas.recursos.models.response.ResposeOperacion;
import com.grupo.salinas.recursos.repository.IContractRepository;
import com.grupo.salinas.recursos.repository.IContractTypeRepository;
import com.grupo.salinas.recursos.repository.IEmployeeRepository;
import com.grupo.salinas.recursos.utils.Utilidades;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ContractEmpleSErviceImpl implements IContractEmpleService {
    @Autowired
    IContractRepository respContra;

    @Override
    public ResposeOperacion guardaContEmplo(Contract contract) {
        ResposeOperacion resp = new ResposeOperacion();
        Contract contract1 = respContra.getContratoByIsActiveByEm(1, contract.getEmployee_id());
        if (contract1 != null && contract1.getIs_active() == 1) {
            contract1.setDate_to(Utilidades.formatDate(new Date()));
            contract1.setIs_active(0);
            respContra.save(contract1);
            Contract resCon = respContra.save(contract);
            resp.setIdEmployee(resCon.getEmployee_id());
            resp.setSuccess(true);
        } else {
            Contract resCon = respContra.save(contract);
            resp.setIdEmployee(resCon.getEmployee_id());
            resp.setSuccess(true);
        }
        return resp;
    }

    @Override
    public ResposeOperacion eliminaContrato(int id) {
        ResposeOperacion resp = new ResposeOperacion();
        Contract con = respContra.getContratoByIsActiveByEm(1, id);
        if (con.getIs_active() != 0) {
            con.setIs_active(0);
            con.setDate_to(Utilidades.formatDate(new Date()));
            resp.setIdEmployee(id);
            resp.setSuccess(true);
        } else {
            resp.setIdEmployee(id);
            resp.setSuccess(false);
            resp.setDesc("No se encuentran Contratos Activos");
        }
        return resp;
    }
}
