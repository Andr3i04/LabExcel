package org.example;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) throws IOException {

        FileInputStream file= new FileInputStream(new File("TestExcel.xlsx"));

        XSSFWorkbook workbook = new XSSFWorkbook(file);

        XSSFSheet sheet = workbook.getSheetAt(0);

        Iterator<Row> rowIterator = sheet.iterator();

        while(rowIterator.hasNext()){
            Row row = rowIterator.next();

            Iterator<Cell> cellIterator = row.cellIterator();

            while(cellIterator.hasNext()){
                Cell cell = cellIterator.next();

                switch(cell.getCellType()){
                    case NUMERIC:
                        System.out.print(cell.getNumericCellValue()+" ");
                        break;

                    case STRING:
                        System.out.print(cell.getStringCellValue()+" ");
                        break;

                    case FORMULA:
                       System.out.print(cell.getCellFormula()+" ");
                       break;

                }
            }
            System.out.println();
        }
        file.close();
    }
}