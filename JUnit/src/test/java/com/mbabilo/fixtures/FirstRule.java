package com.mbabilo.fixtures;

import org.junit.rules.ExternalResource;

public class FirstRule extends ExternalResource {
    @Override
    protected void before() {
        System.out.println("init step");
    }

    @Override
    protected void after() {
        System.out.println("final step");
    }
}
