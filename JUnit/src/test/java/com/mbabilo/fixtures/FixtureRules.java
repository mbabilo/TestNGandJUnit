package com.mbabilo.fixtures;

import org.junit.ClassRule;
import org.junit.rules.ExternalResource;
import org.junit.rules.RuleChain;

import java.io.File;
import java.io.IOException;

import static org.apache.commons.io.FileUtils.deleteDirectory;

public class FixtureRules {

    public static ExternalResource firstRule = new ExternalResource() {
        @Override
        protected void before() {
            System.out.println("init step");
        }

        @Override
        protected void after() {
            System.out.println("final step");
        }
    };

    public static ExternalResource secondRule = new ExternalResource() {
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
    };

    @ClassRule
    public static RuleChain rules = RuleChain.outerRule(firstRule).around(secondRule);


}
