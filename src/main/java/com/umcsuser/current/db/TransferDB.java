package com.umcsuser.current.db;

import com.umcsuser.current.models.Transfer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TransferDB implements Database{
    private final ArrayList<Transfer> transfers = new ArrayList<>();

    @Override
    public void readDatabase(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String linia;
            while ((linia = br.readLine()) != null) {
                String[] parts = linia.split(";");
                transfers.add(new Transfer(
                        parts[0], parts[1], parts[2], parts[3], parts[4], parts[5]
                ));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveDatabase(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for(Transfer transfer: transfers){
                writer.write(transfer.toCSV());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addTransfer(Transfer transfer){
        transfers.add(transfer);
        saveDatabase("transfers.csv");
    }

    public void removeTransfer(String transferID){
        transfers.removeIf(transfer -> transfer.getID().equals(transferID));
        saveDatabase("transfers.csv");
    }

    public void viewTransfers(){
        for(Transfer transfer: transfers){
            System.out.println(transfer.toString());
        }
    }

    public ArrayList<Transfer> getTransfers() {
        return transfers;
    }
}
