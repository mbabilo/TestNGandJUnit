package com.mbabilo.fixtures;

import org.junit.rules.ExternalResource;

import java.io.File;
import java.io.IOException;

import static org.apache.commons.io.FileUtils.deleteDirectory;

public class SecondRule extends ExternalResource {
    @Override
    protected void before() {
        System.out.println("setUp");
        File folder = new File("JUnitFolder");
        System.out.println("folderName is: " + folder);
        boolean flag = folder.mkdir();
    }

    @Override
    protected void after() {
        System.out.println("tearDown");
        try {
            deleteDirectory(new File("JUnitFolder"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}