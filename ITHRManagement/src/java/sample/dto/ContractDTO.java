/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.dto;

import java.sql.Date;

/**
 *
 * @author ADMIN
 */
public class ContractDTO {
    private int id;
    private String Staff_ID;
    private Date StartDate;
    private Date EndDate;
    private String job;
    private double Base_Salary;
    private String Salary_Type;
    private boolean status;

    public ContractDTO() {
    }

    public ContractDTO(int id, String Staff_ID, Date StartDate, Date EndDate, String job, double Base_Salary, String Salary_Type, boolean status) {
        this.id = id;
        this.Staff_ID = Staff_ID;
        this.StartDate = StartDate;
        this.EndDate = EndDate;
        this.job = job;
        this.Base_Salary = Base_Salary;
        this.Salary_Type = Salary_Type;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStaff_ID() {
        return Staff_ID;
    }

    public void setStaff_ID(String Staff_ID) {
        this.Staff_ID = Staff_ID;
    }

    public Date getStartDate() {
        return StartDate;
    }

    public void setStartDate(Date StartDate) {
        this.StartDate = StartDate;
    }

    public Date getEndDate() {
        return EndDate;
    }

    public void setEndDate(Date EndDate) {
        this.EndDate = EndDate;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public double getBase_Salary() {
        return Base_Salary;
    }

    public void setBase_Salary(double Base_Salary) {
        this.Base_Salary = Base_Salary;
    }

    public String getSalary_Type() {
        return Salary_Type;
    }

    public void setSalary_Type(String Salary_Type) {
        this.Salary_Type = Salary_Type;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    
}
