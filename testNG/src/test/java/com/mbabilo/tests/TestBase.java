package com.mbabilo.tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;

import static org.apache.commons.io.FileUtils.deleteDirectory;

public class TestBase {


    @BeforeSuite(alwaysRun = true)
    @Parameters("folderName")
    File setUp(String folderName) {
        System.out.println("setUp");
        File folder = new File(folderName);
        System.out.println("folderName is: " + folder);
        boolean flag = folder.mkdir();
        return folder;

    }

    @AfterSuite(alwaysRun = true)
    @Parameters("folderName")
    void tearDown(String folderName) throws IOException {
        System.out.println("tearDown");
        deleteDirectory(new File(folderName));

    }
}
