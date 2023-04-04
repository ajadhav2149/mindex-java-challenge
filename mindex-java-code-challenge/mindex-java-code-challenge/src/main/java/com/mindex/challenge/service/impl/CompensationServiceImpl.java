package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.CompensationRepository;
import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.service.CompensationService;
import com.mindex.challenge.data.Compensation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class CompensationServiceImpl implements CompensationService {
    private static final Logger LOG = LoggerFactory.getLogger(CompensationServiceImpl.class);

    @Autowired
    CompensationRepository compensationRepository;
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public String create(Compensation compensation) throws Exception{
        LOG.debug("Creating employee compensation [{}]",compensation);
        Employee employee = employeeRepository.findByEmployeeId(compensation.getEmployeeId());
        if(employee == null){
            throw new Exception("The employee doesn't exist");
        }
        if(compensationRepository.findByEmployeeId(compensation.getEmployeeId()) != null){
            throw new Exception("Compensation details already exist");
        }

        compensationRepository.insert(compensation);
        return compensation.getEmployeeId();

    }

    @Override
    public Compensation read(String id) throws Exception{
        Compensation compensation = compensationRepository.findByEmployeeId(id);
        if(compensation == null){
            throw new Exception("No compensation exists");
        }
        compensation.setEmployee(employeeRepository.findByEmployeeId(id));
        return compensation;
    }
}
