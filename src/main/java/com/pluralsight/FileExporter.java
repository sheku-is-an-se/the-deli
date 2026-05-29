package com.pluralsight;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class FileExporter {

    public void saveReceipt(ArrayList<Product> products) {
        File receiptsFolder = new File("receipts");
        if (!receiptsFolder.exists()) {
            receiptsFolder.mkdirs();
        }

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
        String fileName = now.format(formatter) + ".txt";
        String fullPath = "receipts/" + fileName;

        try {
            FileWriter fileWriter = new FileWriter(fullPath);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write("======================================\n");
            bufferedWriter.write("          RECEIPT SUMMARY             \n");
            bufferedWriter.write("======================================\n");

            double total = 0.0;

            for (Product p : products) {
                //Calls my overriden ToString
                bufferedWriter.write(p + "\n");
                bufferedWriter.write("--------------------------------------\n");
                total = total + p.getPrice();
            }

            bufferedWriter.write("======================================\n");
            bufferedWriter.write(" TOTAL PRICE: $" + total + "\n");
            bufferedWriter.write("======================================\n");

            // Close the writer
            bufferedWriter.close();
            System.out.println("Receipt saved successfully as " + fileName);

        } catch (IOException e) {
            System.out.println("Oops! Could not save the receipt.");
        }
    }
}