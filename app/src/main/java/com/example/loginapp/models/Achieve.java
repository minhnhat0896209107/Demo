package com.example.loginapp.models;

import com.google.firebase.auth.FirebaseAuth;

public class Achieve {
    private String targetname;
    private String startdate;
    private String enddate;
    private String target;
    private String used;

    public Achieve() {
    }

    public Achieve(String targetname, String startdate, String enddate, String target, String used) {
        this.targetname = targetname;
        this.startdate = startdate;
        this.enddate = enddate;
        this.target = target;
        this.used = used;
    }

    public String getTargetname() {
        return targetname;
    }

    public void setTargetname(String targetname) {
        this.targetname = targetname;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getUsed() {
        return used;
    }

    public void setUsed(String used) {
        this.used = used;
    }
}
