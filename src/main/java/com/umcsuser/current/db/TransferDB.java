package com.umcsuser.current.db;

import com.umcsuser.current.models.Transfer;

import java.io.*;
import java.util.List;

public class TransferDB implements Database{
    private List<Transfer> transfers;

    @Override
    public void readDatabase(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String linia;
            while ((linia = br.readLine()) != null) {
                System.out.println(linia);
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

    public void addTransfer(Transfer transfer){}

    public void removeTransfer(String transferID){}

    public void viewTransfers(){
        for(Transfer transfer: transfers){
            System.out.println(transfer.toString());
        }
    }
}
