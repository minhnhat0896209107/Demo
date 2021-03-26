package com.example.loginapp.ThongTin;

public class Achieve {
    private String targetname;
    private String startdate;
    private String enddate;
    private int target;
    private int used;

    public Achieve(String targetname, String startdate, String enddate, int target, int used) {
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

    public int getTarget() {
        return target;
    }

    public void setTarget(int target) {
        this.target = target;
    }

    public int getUsed() {
        return used;
    }

    public void setUsed(int used) {
        this.used = used;
    }
}
