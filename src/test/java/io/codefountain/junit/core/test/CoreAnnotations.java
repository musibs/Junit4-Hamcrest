package io.codefountain.junit.core.test;

import org.junit.*;
import static org.junit.Assert.assertEquals;

public class CoreAnnotations {

    @BeforeClass
    public static void runBeforeClass(){
        System.out.println("Running before class");
    }

    @AfterClass
    public static void runAfterClass(){
        System.out.println("Running after class");
    }

    @Before
    public void runBeforeEachTestCase(){
        System.out.println("Running before each test case");
    }

    @After
    public void runAfterEachTestCase(){
        System.out.println("Running after each test case");
    }


    @Test
    public void testCase1(){
        System.out.println("Running test case 1");
        assertEquals(4, 2*2);
    }


    @Test
    public void testCase2(){
        System.out.println("Running test case 2");
        assertEquals(4, 2*2);
    }

    @Test
    public void expectedException(){
        int a = 1/0;
    }
}
