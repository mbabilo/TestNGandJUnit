package com.mbabilo.tests;

import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import static org.testng.Assert.assertTrue;

public class dataProviderTests extends TestBase {


    @Test(dataProvider = "excelDataProvider", dataProviderClass = DataProviders.class)
    @ExcelDataSource("src/test/resources/excel.xlsx")
    public void testExcelOne(String par1, Date par2) {
        System.out.println("Hello, " + par1 + ", " + par2);
    }

    @Test(dataProvider = "excelDataProvider", dataProviderClass = DataProviders.class)
    @ExcelDataSource("src/test/resources/oneMoreExcel.xlsx")
    public void testExcelTwo(String par1, Date par2) {
        System.out.println("Hello, " + par1 + ", " + par2);
    }


    @Test(dataProviderClass = DataProviders.class, dataProvider = "name")
    public void testDP1(String name) throws IOException {
        String relativePath = "dataProviderTests\\" + name;
        System.out.println("positive1");
        File file = new File(relativePath);
        assertTrue(file.createNewFile(), "File " + relativePath + " already exists in the project root directory");
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "loadNameFromFile")
    public void testDP2(String name) throws IOException {
        String relativePath = "dataProviderTests\\" + name;
        System.out.println("positive2");
        File file = new File(relativePath);
        assertTrue(file.createNewFile(), "File " + relativePath + " already exists in the project root directory");
    }

}
