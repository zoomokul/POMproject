package paketler.tests;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteExcel {
    @Test
    public void writeExcel() throws IOException {

        String path="src/test/java/resources/languages.xlsx";
        FileInputStream fileInputStream = new FileInputStream(path);



        Workbook workbook= WorkbookFactory.create(fileInputStream);


        workbook.getSheetAt(0).getRow(0).createCell(2).setCellValue("Continent");
       workbook.getSheetAt(0).getRow(1).createCell(2).setCellValue("Europa");
       workbook.getSheetAt(0).getRow(2).createCell(2).setCellValue("Europa");
        workbook.getSheetAt(0).getRow(3).createCell(2).setCellValue("Europa");


        FileOutputStream fileOutputStream=new FileOutputStream(path);
        workbook.write(fileOutputStream);





    }
}
