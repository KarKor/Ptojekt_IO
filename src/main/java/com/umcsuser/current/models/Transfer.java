package com.umcsuser.current.models;

public class Transfer {
    private String startLocation;
    private String endLocation;
    private String startTime;
    private String endTime;
    private String trainID;
    private String ID;

    public Transfer(String ID, String startLocation, String endLocation, String startTime, String endTime, String trainID) {
        this.endLocation = endLocation;
        this.endTime = endTime;
        this.ID = ID;
        this.startLocation = startLocation;
        this.startTime = startTime;
        this.trainID = trainID;
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

    @Override
    public String toString() {
        return "Transfer number " + ID + " from " + startLocation + " to " + endLocation + "\ndeparting at " + startTime + "\narriving at" + endTime;
    }

    public String toCSV(){
        return this.startTime+';'+this.endTime+';'+this.startLocation+';'+this.endLocation+';'+this.ID+';'+this.trainID;
    }
}
