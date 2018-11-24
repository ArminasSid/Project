/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groupwork;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Juliu
 */
public class DistanceData {

    public DistanceData() throws FileNotFoundException, IOException, InvalidFormatException {
        readDistanceData();
    }

    private void readDistanceData() throws FileNotFoundException, IOException, InvalidFormatException {
        OPCPackage pkg = OPCPackage.open(new File("D:/Distances.xlsx"));
        XSSFWorkbook wb = new XSSFWorkbook(pkg);
        XSSFSheet sheet = wb.getSheetAt(0);
       // pkg.close();
        Distance temp = new Distance();
        for (int i = 1; i < sheet.getLastRowNum(); i++) {
          temp.Set(sheet.getRow(i).getCell(1).getStringCellValue(),sheet.getRow(i).getCell(2).getStringCellValue(),
                    sheet.getRow(i).getCell(3).getNumericCellValue(),sheet.getRow(i).getCell(4).getNumericCellValue());
        }
    }

}
