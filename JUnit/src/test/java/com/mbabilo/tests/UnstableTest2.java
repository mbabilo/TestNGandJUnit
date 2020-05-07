package com.mbabilo.tests;

import com.mbabilo.fixtures.RunAgain;
import com.mbabilo.fixtures.RunTwice;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;


public class UnstableTest2 {

    @Rule
    public TestRule runAgain = new RunAgain();

    private static int attempt = 1;

    @Test

    public void unstableTest() {
        if (attempt == 2) {
            attempt = 1;
        } else {
            Assert.fail("Failed on " + (attempt++) + " attempt");
        }
    }


}
