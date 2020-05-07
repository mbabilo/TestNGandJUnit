package com.mbabilo.fixtures;

import com.mbabilo.tests.Unstable;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class RunAgain extends TestWatcher {

    @Override
    public Statement apply(Statement base, Description desc) {
        return new RunTwiceStatement(base, desc);
    }

    public class RunTwiceStatement extends Statement {

        private final Statement base;
        private Description desc;
        private int i = 0;
        int nTry;

        public RunTwiceStatement(Statement base, Description desc) {
            this.base = base;
            this.desc = desc;
            Unstable ta = desc.getAnnotation(Unstable.class);
            System.out.println(ta.value());
            this.nTry = ta.value();
        }

        @Override
        public void evaluate() throws Throwable {
            while (i < nTry)
                try {
                    i++;
                    System.out.println("Try: " + i);
                    base.evaluate();
                    System.out.println("PASS");
                    break;
                } catch (Throwable t) {
                    System.out.println("Failed on " + i + " attempt: " + desc);
                }
        }
        }

    }
