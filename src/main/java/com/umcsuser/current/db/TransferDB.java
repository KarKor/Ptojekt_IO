package com.umcsuser.current.db;

import com.umcsuser.current.models.Transfer;

import java.io.*;
import java.util.List;

public class TransferDB implements Database{
    private List<Transfer> transfers;

    public List<Transfer> getTransfers() {
        return transfers;
    }

    @Override
    public void readDatabase(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String linia;
            while ((linia = br.readLine()) != null) {
                String[] dane = linia.split(";");
                if (dane.length >= 6) {
                    String ID = dane[0];
                    String startLocation = dane[1];
                    String endLocation = dane[2];
                    String startTime = dane[3];
                    String endTime = dane[4];
                    String trainID = dane[5];

                    Transfer transfer = new Transfer(ID, startLocation, endLocation, startTime, endTime, trainID);
                    transfers.add(transfer);
                }
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
        if (transfer != null) {
            transfers.add(transfer);
            System.out.println("Pomyślnie dodano nowy przejazd.");
        }
    }

    public void removeTransfer(String transferID){
        boolean isRemoved = transfers.removeIf(transfer -> transfer.getID().equals(transferID));

        if (isRemoved) {
            System.out.println("Usunięto przejazd o ID: " + transferID);
        } else {
            System.out.println("Nie znaleziono przejazdu o ID: " + transferID);
        }
    }


    public void viewTransfers(){
        for(Transfer transfer: transfers){
            System.out.println(transfer.toString());
        }
    }
}
