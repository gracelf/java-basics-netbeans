/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaBasics;

import org.junit.After;
import org.junit.Test;

/**
 *
 * @author grace.fu
 */
public class TestHashCodeEqualTest {
    
    public TestHashCodeEqualTest() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of equals method, of class TestHashCodeEqual.
     */
    @Test
    public void testEquals() {
        TestHashCodeEqualTest crunchifyTest = new TestHashCodeEqualTest();
        TestHashCodeEqual one = new TestHashCodeEqual(1);
        TestHashCodeEqual two = new TestHashCodeEqual(1);
        crunchifyTest.test1(one, two);

        TestHashCodeEqual three = new TestHashCodeEqual(1);
        TestHashCodeEqual four = new TestHashCodeEqual(2);
        crunchifyTest.test2(three, four);
    }

    
    
    public void test1(TestHashCodeEqual one, TestHashCodeEqual two) {
        if (one.equals(two)) {
            System.out.println("Test1: One and Two are equal");
        } else {
            System.out.println("Test1: One and Two are not equal");
        }
    }

    public void test2(TestHashCodeEqual three, TestHashCodeEqual four) {
        if (three.equals(four)) {
            System.out.println("Test2: Three and Four are equal");
        } else {
            System.out.println("Test2: Three and Four are not equal");
        }
    }
    
}
