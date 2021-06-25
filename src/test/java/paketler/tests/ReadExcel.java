package paketler.tests;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import paketler.utilities.ConfigReader;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReadExcel {
    @Test
    public void readExcel() throws IOException {

        String excelPath="src/test/java/resources/languages.xlsx";  //yol

        FileInputStream fileInputStream=new FileInputStream(excelPath);

        Workbook workBook = WorkbookFactory.create(fileInputStream);

        Sheet sheet=workBook.getSheet("Sheet1");

        Row row = sheet.getRow(3);

        Cell cell=row.getCell(1); //French

        System.out.println(cell);


    }

    @Test
    public void readExcel2() throws IOException {


        String excelPath="src/test/java/resources/languages.xlsx";

        FileInputStream fileInputStream=new FileInputStream(excelPath);
        Workbook workbook=WorkbookFactory.create(fileInputStream);
        Cell cell=workbook.
                getSheet("Sheet1").
                getRow(3).
                getCell(1); //Integer.parseInt(ConfigReader.getProperty("1"))

        System.out.println(cell);

        System.out.println(cell.toString());



        System.out.println(workbook.getSheet("Sheet1").getLastRowNum());

        System.out.println(workbook.getSheet("Sheet1").getPhysicalNumberOfRows());
        // getPhysicalNumberOfRows() give us row number which include data


        int lastIndex=workbook.getSheetAt(0).getLastRowNum();

        for (int index=1 ; index<=lastIndex ; index++){

            String language= workbook.getSheetAt(0).getRow(index).getCell(1).toString();
            System.out.println(language);

        }


        Map<String,String> countryMap = new HashMap<>();
        String key="";
        String value="";

        for (int index=1 ; index<=lastIndex ; index++){

            key=workbook.getSheetAt(0).getRow(index).getCell(0).toString();

            value= workbook.getSheetAt(0).getRow(index).getCell(1).toString();


            countryMap.put(key,value);
        }

        System.out.println(countryMap);

        fileInputStream.close();
        workbook.close();

    }

}
