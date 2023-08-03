/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.dto;

import java.sql.Date;

/**
 *
 * @author Admin
 */
public class User {
    private String ID;
    private String Email;
    private String FullName;
    private Date Dob;
    private Boolean Gender;
    private String Address;
    private String Password;
    private String Image;
    private String BankAccountNumber;
    private String BankAccountName;
    private String BankName;
    private String Role;
    private int leave_balance;

    public User() {
    }

    public User(String ID, String Email, String FullName, Date Dob, Boolean Gender, String Address, String Password, String Image, String BankAccountNumber, String BankAccountName, String BankName, String Role, int leave_balance) {
        this.ID = ID;
        this.Email = Email;
        this.FullName = FullName;
        this.Dob = Dob;
        this.Gender = Gender;
        this.Address = Address;
        this.Password = Password;
        this.Image = Image;
        this.BankAccountNumber = BankAccountNumber;
        this.BankAccountName = BankAccountName;
        this.BankName = BankName;
        this.Role = Role;
        this.leave_balance = leave_balance;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String FullName) {
        this.FullName = FullName;
    }

    public Date getDob() {
        return Dob;
    }

    public void setDob(Date Dob) {
        this.Dob = Dob;
    }

    public Boolean getGender() {
        return Gender;
    }

    public void setGender(Boolean Gender) {
        this.Gender = Gender;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String Image) {
        this.Image = Image;
    }

    public String getBankAccountNumber() {
        return BankAccountNumber;
    }

    public void setBankAccountNumber(String BankAccountNumber) {
        this.BankAccountNumber = BankAccountNumber;
    }

    public String getBankAccountName() {
        return BankAccountName;
    }

    public void setBankAccountName(String BankAccountName) {
        this.BankAccountName = BankAccountName;
    }

    public String getBankName() {
        return BankName;
    }

    public void setBankName(String BankName) {
        this.BankName = BankName;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String Role) {
        this.Role = Role;
    }

    public int getLeave_balance() {
        return leave_balance;
    }

    public void setLeave_balance(int leave_balance) {
        this.leave_balance = leave_balance;
    }
    
}
