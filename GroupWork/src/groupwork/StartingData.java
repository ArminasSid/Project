/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groupwork;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    


    public StartingData()
    {
        try {
            ReadData();
        } catch (IOException ex) {
            Logger.getLogger(StartingData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    private void ReadData() throws IOException {
    
        File excelFile = new File("Data for calculations.xlsx");
        FileInputStream fis = new FileInputStream(excelFile);
        HSSFSheet
    }
    
}
