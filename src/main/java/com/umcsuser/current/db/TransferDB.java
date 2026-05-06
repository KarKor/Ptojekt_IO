package com.umcsuser.current.db;

import com.umcsuser.current.models.Transfer;

import java.util.List;

public class TransferDB implements Database{
    private List<Transfer> transfers;

    @Override
    public void readDatabase(String filePath) {

    }

    @Override
    public void saveDatabase(String filePath) {

    }

    public void addTransfer(Transfer transfer){}

    public void removeTransfer(String transferID){}

    public void viewTransfers(){}
}
