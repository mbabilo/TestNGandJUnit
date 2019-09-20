package com.mbabilo.fixtures;

import org.junit.ClassRule;
import org.junit.rules.ExternalResource;
import org.junit.rules.RuleChain;

public class CopyOfFixtureRules {

    public static ExternalResource firstRule = new FirstRule();

    public static ExternalResource secondRule = new SecondRule();

    @ClassRule
    public static RuleChain rules = RuleChain.outerRule(firstRule).around(secondRule);

}
