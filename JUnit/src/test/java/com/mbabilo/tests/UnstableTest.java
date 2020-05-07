package com.mbabilo.tests;

import com.mbabilo.fixtures.RunAgain;
import com.mbabilo.fixtures.RunTwice;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;


    public class UnstableTest {


        @Rule
        public TestRule runAgain = new RunAgain();
        private static int attempt = 1;

        @Test
        @Unstable(10)
        public void unstableTest() {
            System.out.println("now in test attempt =  " + attempt);
            if (attempt == 4) {
                attempt = 1;
            } else {
                Assert.fail("Failed on " + (attempt++) + " attempt");
            }
        }


    }
