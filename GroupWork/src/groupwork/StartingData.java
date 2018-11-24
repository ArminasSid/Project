/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groupwork;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Juliu
 */
public class StartingData {

    private double FixedConstruction;
    private double VariableConstruction;
    private double FixedMananagement;
    private double VariableManagement;
    private double TruckDelivery;
    private double RailwayDelivery;
    private double TruckEmission;
    private double RailwayEmission;

    public StartingData() {
        try {
            ReadData();
        } catch (IOException ex) {
            Logger.getLogger(StartingData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void ReadData() throws IOException {
        InputStream ExcelFileToRead = new FileInputStream("D:/new.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(ExcelFileToRead);
        XSSFSheet sheet = wb.getSheetAt(0);
        String temp = sheet.getRow(1).getCell(2).getRawValue();
        FixedConstruction = Double.parseDouble(temp);
        temp = sheet.getRow(2).getCell(2).getRawValue();
        VariableConstruction = Double.parseDouble(temp);
        temp = sheet.getRow(3).getCell(2).getRawValue();
        FixedMananagement = Double.parseDouble(temp);
        temp = sheet.getRow(4).getCell(2).getRawValue();
        VariableManagement = Double.parseDouble(temp);
        temp = sheet.getRow(5).getCell(2).getRawValue();
        TruckDelivery = Double.parseDouble(temp);
        temp = sheet.getRow(6).getCell(2).getRawValue();
        RailwayDelivery = Double.parseDouble(temp);
        temp = sheet.getRow(7).getCell(2).getRawValue();
        TruckEmission = Double.parseDouble(temp);
        temp = sheet.getRow(8).getCell(2).getRawValue();
        RailwayEmission = Double.parseDouble(temp);
    }
    public double getFixedConstruction()
    {
        return FixedConstruction;
    }
    public double getVariableConstruction()
    {
        return VariableConstruction;
    }
    public double getFixedMananagement()
    {
        return FixedMananagement;
    }
    public double getVariableManagement()
    {
        return VariableManagement;
    }
    public double getTruckDelivery()
    {
        return TruckDelivery;
    }
    public double getRailwayDelivery()
    {
        return RailwayDelivery;
    }
    public double getTruckEmission()
    {
        return TruckEmission;
    }
    public double getRailwayEmission()
    {
        return RailwayEmission;
    }
    

}
