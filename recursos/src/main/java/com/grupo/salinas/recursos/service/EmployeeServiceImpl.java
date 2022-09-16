package com.grupo.salinas.recursos.service;

import com.grupo.salinas.recursos.models.Contract;
import com.grupo.salinas.recursos.models.ContractType;
import com.grupo.salinas.recursos.models.Employee;
import com.grupo.salinas.recursos.models.response.EmployeeResponse;
import com.grupo.salinas.recursos.models.response.ResposeOperacion;
import com.grupo.salinas.recursos.repository.IContractRepository;
import com.grupo.salinas.recursos.repository.IContractTypeRepository;
import com.grupo.salinas.recursos.repository.IEmployeeRepository;
import com.grupo.salinas.recursos.utils.Utilidades;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired
    IEmployeeRepository respEmp;
    @Autowired
    IContractRepository respContra;
    @Autowired
    IContractTypeRepository respContraType;

    @Override
    public ArrayList<EmployeeResponse> getEmpleados() {
        ArrayList<Employee> listResp = (ArrayList<Employee>) respEmp.findAll();
        ArrayList<EmployeeResponse> listEmployee = new ArrayList<EmployeeResponse>();
        listResp.forEach(o -> {
            EmployeeResponse resp = new EmployeeResponse();
            Contract contract = respContra.getContratoByIdEmple(o.getEmployee_id());
            if (contract != null) {
                ContractType contractType = respContraType.getById(contract.getContract_type_id() != 0 ? contract.getContract_type_id() : null);
                resp.setContractName(contractType.getName());
                resp.setSalaryPerDay(String.valueOf(contract.getSalary_per_day()));
                resp.setDateToContract(contract.getDate_to());
            }
            resp.setEmail(o.getEmail());
            resp.setFullName(o.getName() + " " + o.getLast_name());
            resp.setAxIdNumber(o.getTax_id_number());

            listEmployee.add(resp);

        });
        return listEmployee;
    }

    @Override
    public ResposeOperacion guardaEmpleado(Employee employee) {
        ResposeOperacion resp = new ResposeOperacion();
        if (Utilidades.validaFormato(employee.getTax_id_number(), employee.getBirth_date())) {
            Employee emp = respEmp.getByRFC(employee.getTax_id_number());
            if (emp != null && !emp.getTax_id_number().equals("")) {
                resp.setSuccess(false);
                resp.setDesc("EL cliente ya se encuentra registrado");
            } else {
                Employee em = respEmp.save(employee);
                resp.setIdEmployee(em.getEmployee_id());
                resp.setSuccess(true);
            }
        } else {
            resp.setSuccess(false);
            resp.setDesc("Error al Validar tax_id_number no cuenta con los criterios");
        }
        return resp;
    }

    @Override
    public ResposeOperacion modificaEmpleado(int id, Employee employee) {
        ResposeOperacion resp = new ResposeOperacion();
        Optional<Employee> empl = respEmp.findById(id);
        if (empl.get().getTax_id_number().equals(employee.getTax_id_number())) {
            empl.get().setEmail(Utilidades.validaCadena(empl.get().getEmail(), employee.getEmail()));
            empl.get().setBirth_date(Utilidades.validaCadena(empl.get().getBirth_date(), employee.getBirth_date()));
            empl.get().setName(Utilidades.validaCadena(empl.get().getName(), employee.getName()));
            empl.get().setCell_phone(Utilidades.validaCadena(empl.get().getCell_phone(), employee.getCell_phone()));
            empl.get().setIs_active(employee.getIs_active());
            empl.get().setDate_created(Utilidades.validaCadena(empl.get().getDate_created(), employee.getDate_created()));
            empl.get().setTax_id_number(Utilidades.validaCadena(empl.get().getTax_id_number(), employee.getTax_id_number()));
            empl.get().setLast_name(Utilidades.validaCadena(empl.get().getLast_name(), employee.getLast_name()));

            Employee empRes = respEmp.save(empl.get());
            resp.setSuccess(true);
            resp.setIdEmployee(empRes.getEmployee_id());

        } else {
            if (Utilidades.validaFormato(employee.getTax_id_number(), employee.getBirth_date())) {
                empl.get().setEmail(Utilidades.validaCadena(empl.get().getEmail(), employee.getEmail()));
                empl.get().setBirth_date(Utilidades.validaCadena(empl.get().getBirth_date(), employee.getBirth_date()));
                empl.get().setName(Utilidades.validaCadena(empl.get().getName(), employee.getName()));
                empl.get().setCell_phone(Utilidades.validaCadena(empl.get().getCell_phone(), employee.getCell_phone()));
                empl.get().setIs_active(employee.getIs_active());
                empl.get().setDate_created(Utilidades.validaCadena(empl.get().getDate_created(), employee.getDate_created()));
                empl.get().setTax_id_number(Utilidades.validaCadena(empl.get().getTax_id_number(), employee.getTax_id_number()));
                empl.get().setLast_name(Utilidades.validaCadena(empl.get().getLast_name(), employee.getLast_name()));

                Employee empRes = respEmp.save(empl.get());
                resp.setSuccess(true);
                resp.setIdEmployee(empRes.getEmployee_id());
            } else {
                resp.setSuccess(false);
                resp.setDesc("tax_id_number no cumple con un formato Valido");
            }
        }
        return resp;
    }
}
