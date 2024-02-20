package com.csi.service;

import com.csi.model.Employee;
import com.csi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl {

    @Autowired
    private EmployeeRepository employeeRepositoryImpl;

    public Employee signUp(Employee employee) {
        return employeeRepositoryImpl.save(employee);
    }

    public boolean signIn(String empEmailId, String emppassword) {
        boolean flag = false;

        for (Employee employee : employeeRepositoryImpl.findAll()) {
            if (employee.getEmpEmailId().equals(empEmailId) && employee.getEmpPassword().equals(emppassword)) {
                flag = true;
                break;
            }
        }

        return flag;
    }

    public Optional<Employee> findById(int empId) {
        return employeeRepositoryImpl.findById(empId);
    }

    public List<Employee> findAll() {
        return employeeRepositoryImpl.findAll();
    }

    public Employee update(Employee employee) {
        return employeeRepositoryImpl.save(employee);
    }

    public void deleteById(int empId) {
        employeeRepositoryImpl.deleteById(empId);
    }


}