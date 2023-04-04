package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.ReportingStructureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.Queue;

@Service
public class ReportingStructureServiceImpl implements ReportingStructureService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public ReportingStructure read(String employeeId) {
        int numberOfReportees = 0;
        Queue<Employee> reporteesQueue = new LinkedList<>();
        Employee employee = employeeRepository.findByEmployeeId(employeeId);
        ReportingStructure reportingStructure = new ReportingStructure();
        reportingStructure.setEmployee(employee);

        numberOfReportees = directReportInitialize(employee, numberOfReportees, reporteesQueue);

        while(!reporteesQueue.isEmpty()){
            employeeId = reporteesQueue.poll().getEmployeeId();
            employee = employeeRepository.findByEmployeeId(employeeId);
            numberOfReportees = directReportInitialize(employee, numberOfReportees, reporteesQueue);
        }
        reportingStructure.setNumberOfReports(numberOfReportees);
        return reportingStructure;
    }

    public int directReportInitialize(Employee employee, int numberofReportees, Queue<Employee> reporteesQueue){
        if(employee.getDirectReports() != null){
            numberofReportees += employee.getDirectReports().size();
            reporteesQueue.addAll(employee.getDirectReports());
        }
        return numberofReportees;
    }

}
