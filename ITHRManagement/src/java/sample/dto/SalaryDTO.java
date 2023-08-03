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
public class SalaryDTO {
    private int id;
    private String Staff_ID;
    private int standard_wh;
    private int actual_wh;
    private int leave_hour;
    private double Basic_salary;
    private double BHYT;
    private double BHXH;
    private double BHTN;
    private double Tax;
    private double Bonus;
    private double total;
    private String note;
    private Date date;
    private String BankNum;
    private String BankAccName;
    private String BankName;

    public SalaryDTO() {
    }

    public SalaryDTO(int id, String Staff_ID, int standard_wh, int actual_wh, int leave_hour, double Basic_salary, double BHYT, double BHXH, double BHTN, double Tax, double Bonus, double total, String note, Date date, String BankNum, String BankAccName, String BankName) {
        this.id = id;
        this.Staff_ID = Staff_ID;
        this.standard_wh = standard_wh;
        this.actual_wh = actual_wh;
        this.leave_hour = leave_hour;
        this.Basic_salary = Basic_salary;
        this.BHYT = BHYT;
        this.BHXH = BHXH;
        this.BHTN = BHTN;
        this.Tax = Tax;
        this.Bonus = Bonus;
        this.total = total;
        this.note = note;
        this.date = date;
        this.BankNum = BankNum;
        this.BankAccName = BankAccName;
        this.BankName = BankName;
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

    public int getStandard_wh() {
        return standard_wh;
    }

    public void setStandard_wh(int standard_wh) {
        this.standard_wh = standard_wh;
    }

    public int getActual_wh() {
        return actual_wh;
    }

    public void setActual_wh(int actual_wh) {
        this.actual_wh = actual_wh;
    }

    public int getLeave_hour() {
        return leave_hour;
    }

    public void setLeave_hour(int leave_hour) {
        this.leave_hour = leave_hour;
    }

    public double getBasic_salary() {
        return Basic_salary;
    }

    public void setBasic_salary(double Basic_salary) {
        this.Basic_salary = Basic_salary;
    }

    public double getBHYT() {
        return BHYT;
    }

    public void setBHYT(double BHYT) {
        this.BHYT = BHYT;
    }

    public double getBHXH() {
        return BHXH;
    }

    public void setBHXH(double BHXH) {
        this.BHXH = BHXH;
    }

    public double getBHTN() {
        return BHTN;
    }

    public void setBHTN(double BHTN) {
        this.BHTN = BHTN;
    }

    public double getTax() {
        return Tax;
    }

    public void setTax(double Tax) {
        this.Tax = Tax;
    }

    public double getBonus() {
        return Bonus;
    }

    public void setBonus(double Bonus) {
        this.Bonus = Bonus;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getBankNum() {
        return BankNum;
    }

    public void setBankNum(String BankNum) {
        this.BankNum = BankNum;
    }

    public String getBankAccName() {
        return BankAccName;
    }

    public void setBankAccName(String BankAccName) {
        this.BankAccName = BankAccName;
    }

    public String getBankName() {
        return BankName;
    }

    public void setBankName(String BankName) {
        this.BankName = BankName;
    }

    
    
    
}
