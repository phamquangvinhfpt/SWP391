/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.dto;

import java.sql.Date;

/**
 *
 * @author Vinh
 */
public class leave_log {
    private int ID;
    private String User_ID;
    private Date StartDate;
    private Date EnDate;
    private String Reason;
    private int Status;

    public leave_log() {
    }

    public leave_log(int ID, String User_ID, Date StartDate, Date EnDate, String Reason, int Status) {
        this.ID = ID;
        this.User_ID = User_ID;
        this.StartDate = StartDate;
        this.EnDate = EnDate;
        this.Reason = Reason;
        this.Status = Status;
    }

    public leave_log(String User_ID, Date StartDate, Date EnDate, String Reason, int Status) {
        this.User_ID = User_ID;
        this.StartDate = StartDate;
        this.EnDate = EnDate;
        this.Reason = Reason;
        this.Status = Status;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUser_ID() {
        return User_ID;
    }

    public void setUser_ID(String User_ID) {
        this.User_ID = User_ID;
    }

    public Date getStartDate() {
        return StartDate;
    }

    public void setStartDate(Date StartDate) {
        this.StartDate = StartDate;
    }

    public Date getEnDate() {
        return EnDate;
    }

    public void setEnDate(Date EnDate) {
        this.EnDate = EnDate;
    }

    public String getReason() {
        return Reason;
    }

    public void setReason(String Reason) {
        this.Reason = Reason;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }
    
    
}
