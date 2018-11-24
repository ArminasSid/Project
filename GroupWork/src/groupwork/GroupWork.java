/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groupwork;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 *
 * @author Juliu
 */
public class GroupWork {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException, InvalidFormatException {
        StartingData a = new StartingData();
        //   File input = new File("D:/IT PROJEKTAS/Project/GroupWork/Data0.xlsx");
        // Workbook wb = WorkbookFactory;
        /*FileInputStream fs = new FileInputStream(new File("C:\\Data0.xlsx"));
        HSSFWorkbook wb = new HSSFWorkbook();*/
 /* HSSFSheet ab = wb.createSheet("asd");
        FileOutputStream out
                = new FileOutputStream(new File("D:\\new.xls"));
        wb.write(out);
        out.close();*/
        // File file = new File("D:\\new.xls");
       /* InputStream ExcelFileToRead = new FileInputStream("D:\\new.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(ExcelFileToRead);

        XSSFWorkbook test = new XSSFWorkbook();

        XSSFSheet sheet = wb.getSheetAt(0);*/

        /* Workbook workbook = WorkbookFactory.create(file);
        Sheet sheet = workbook.getSheetAt(0);*/
        //   sheet.getRow(0).getCell(0).toString();
        /*Cell cell = null;
        cell = sheet.getRow(1).getCell(1);
        String g = "gg";
        cell.setCellValue(g);

        FileOutputStream outFile = new FileOutputStream(new File("D:\\new.xls"));
        workbook.write(outFile);
        outFile.close();*/
        //FileInputStream fis = new FileInputStream("Data0.xlsx");
        //  Workbook wb = new XSSFWorkbook(fis);
        //Workbook wb = WorkbookFactory.create(fis);
        // Sheet sh = wb.getSheet("Sheet1");
        //sh.getRow(0);
        // sheet.getRow(0);
       // System.out.print(sheet.getRow(0).getCell(0));
     //  readXLSXFile();
    }

    public static void readXLSXFile() throws IOException {
        InputStream ExcelFileToRead = new FileInputStream("D:/new.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(ExcelFileToRead);

        XSSFWorkbook test = new XSSFWorkbook();

        XSSFSheet sheet = wb.getSheetAt(0);
        XSSFRow row;
        XSSFCell cell;

         System.out.println(sheet.getRow(1).getCell(2));
         Iterator rows = sheet.rowIterator();
         while (rows.hasNext())
         {
             
         }
         
        //Iterator rows = sheet.rowIterator();

        /*while (rows.hasNext()) {
            row = (XSSFRow) rows.next();
            Iterator cells = row.cellIterator();
            while (cells.hasNext()) {
                cell = (XSSFCell) cells.next();
               // System.out.println(cell.toString());
            }
        }*/

    }

}
