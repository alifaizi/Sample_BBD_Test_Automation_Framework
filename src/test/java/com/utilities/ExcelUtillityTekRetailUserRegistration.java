package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
//Created by Jan Ali Faizi for demonstration and learning purposes only. 
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Color;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtillityTekRetailUserRegistration {
	
	private FileInputStream fis;
    private FileOutputStream fileOut;
    private Workbook wb;
    private Sheet sh;
    private Cell cell;
    private Row row;
    private CellStyle cellstyle;
    private Color mycolor;
    private String excelFilePath;
    private Map<String, Integer> columns = new HashMap<>();

    public void setExcelFile(String ExcelPath, String SheetName) throws Exception {
        try {
            File fis = new File(ExcelPath);
            wb = WorkbookFactory.create(fis);
            sh = wb.getSheet(SheetName);
            
            //sh = wb.getSheetAt(0); //0 - index of 1st sheet
//            if (sh == null) {
//                sh = wb.createSheet(SheetName);
//            }

            this.excelFilePath = ExcelPath;

            //adding all the column header names to the map 'columns'
            sh.getRow(0).forEach(cell ->{
                columns.put(cell.getStringCellValue(), cell.getColumnIndex());
            });

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public String getCellData(int rownum, int colnum) throws Exception{
        try{
            cell = sh.getRow(rownum).getCell(colnum);
            String CellData = null;
            switch (cell.getCellType()){
                case STRING:
                    CellData = cell.getStringCellValue();
                    break;
                case NUMERIC:
                    if (DateUtil.isCellDateFormatted(cell))
                    {
                        CellData = String.valueOf(cell.getDateCellValue());
                    }
                    else
                    {
                        CellData = String.valueOf((long)cell.getNumericCellValue());
                    }
                    break;
                case BOOLEAN:
                    CellData = Boolean.toString(cell.getBooleanCellValue());
                    break;
                case BLANK:
                    CellData = "";
                    break;
            }
            return CellData;
        }catch (Exception e){
            return"";
        }
    }

    public String getCellData(String columnName, int rownum) throws Exception {
        return getCellData(rownum, columns.get(columnName));
    }
    
    public static void main(String []args) throws Exception {
    	
    	ExcelUtillityTekRetailUserRegistration excel = new ExcelUtillityTekRetailUserRegistration();
        excel.setExcelFile(".\\src\\test\\resources\\testdata\\TestDataForApachePoi.xlsx", "Sheet1");
        
        System.out.println(excel.getCellData("first_name", 1));
        System.out.println(excel.getCellData("last_name", 1));
        System.out.println(excel.getCellData("email", 1));
        System.out.println(excel.getCellData("telephone", 1));
        System.out.println(excel.getCellData("password", 1));
        System.out.println(excel.getCellData("confirm_password", 1));
        
	}
    
}
