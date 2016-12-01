package de.bit.camel.security;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * 
 * @author Rami TORKHANI
 */
@RunWith(Suite.class)
@SuiteClasses({TestBob.class, TestAlice.class, TestEve.class})
public class TestAll {
}
