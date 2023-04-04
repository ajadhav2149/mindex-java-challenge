package com.mindex.challenge.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Compensation {
    private Employee employee;
    @NotBlank
    @NotNull
    @NotEmpty
    private String employeeId;
    private long salary;
    private Date effectiveDate;

    public String getEmployeeId(){return employeeId;}
    public void setEmployeeId(String employeeId){this.employeeId = employeeId;}
    public long getSalary(){return salary;}
    public void setSalary(long salary){this.salary = salary;}
    public Date getEffectiveDate(){return effectiveDate;}
    public void setEffectiveDate(Date effectiveDate){this.effectiveDate = effectiveDate;}
    public Employee getEmployee(){return employee;}
    public void setEmployee(Employee employee){this.employee = employee;}

    @Override
    public String toString(){
        return "Compensation{" +
                "employee=" + employee +
                ", employeeId='" + employeeId + '\'' +
                ", salary=" + salary +
                ", effectiveDate=" + effectiveDate +
                '}';
    }
}
