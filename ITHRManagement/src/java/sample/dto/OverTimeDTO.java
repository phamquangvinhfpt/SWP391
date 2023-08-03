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
public class OverTimeDTO {
    private int id;
    private String Staff_ID;
    private Date date;
    private boolean status;
    private int Valid_OT;

    public OverTimeDTO() {
    }

    public OverTimeDTO(int id, String Staff_ID, Date date, boolean status, int Valid_OT) {
        this.id = id;
        this.Staff_ID = Staff_ID;
        this.date = date;
        this.status = status;
        this.Valid_OT = Valid_OT;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getValid_OT() {
        return Valid_OT;
    }

    public void setValid_OT(int Valid_OT) {
        this.Valid_OT = Valid_OT;
    }
    
    
}
