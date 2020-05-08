package com.mbabilo.tests;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import static java.lang.StrictMath.random;

public class DataProviders {


    @DataProvider
    public static Iterator<Object[]> excelDataProvider(Method m) throws IOException, InvalidFormatException {
        if (m.isAnnotationPresent(ExcelDataSource.class)) {
            ArrayList<Object[]> result = new ArrayList<>();
            ExcelDataSource excelDataSource = m.getAnnotation(ExcelDataSource.class);
            String excelFile = excelDataSource.value();

            XSSFWorkbook myExcelBook = new XSSFWorkbook(new File(excelFile));
            XSSFSheet myExcelSheet = myExcelBook.getSheet("Sheet1");

            for (int i = 0; i < myExcelSheet.getPhysicalNumberOfRows(); i++) {
                XSSFRow row = myExcelSheet.getRow(i);

                String name = row.getCell(0).getStringCellValue();
                Date birthdate = row.getCell(1).getDateCellValue();

                result.add(new Object[]{String.valueOf(name), birthdate});

            }
            myExcelBook.close();

            return result.iterator();
        } else {
            throw new Error("There is no @ExcelDataSource annotation on method " + m);
        }
    }


    @DataProvider
    public static Iterator<Object[]> name() {
        List<Object[]> data = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            data.add(new Object[]{String.valueOf(random())});
        }
        return data.iterator();
    }

    @DataProvider
    public static Iterator<Object[]> loadNameFromFile() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(
                DataProviders.class.getResourceAsStream("/names.data")));

        List<Object[]> data = new ArrayList<Object[]>();
        String line = in.readLine();
        while (line != null) {
            data.add(line.split("\n"));
            line = in.readLine();
        }
        in.close();
        return data.iterator();
    }


}
