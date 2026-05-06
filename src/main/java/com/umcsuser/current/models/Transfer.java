package com.umcsuser.current.models;

public class Transfer {
    private String startLocation;
    private String endLocation;
    private String startTime;
    private String endTime;
    private String trainID;
    private String ID;

    public Transfer(String endLocation, String endTime, String ID, String startLocation, String startTime) {
        this.endLocation = endLocation;
        this.endTime = endTime;
        this.ID = ID;
        this.startLocation = startLocation;
        this.startTime = startTime;
    }

    public String getEndLocation() {
        return endLocation;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getID() {
        return ID;
    }

    public String getStartLocation() {
        return startLocation;
    }

    public String getStartTime() {
        return startTime;
    }
}
