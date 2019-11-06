package io.codefountain.junit.core.test;

import org.junit.*;
import org.junit.rules.Timeout;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class CoreAnnotations {

    //@Rule
    //public Timeout timeOut = Timeout.seconds(5);

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
    @Ignore
    public void testCase2(){
        System.out.println("Running test case 2");
        assertEquals(4, 2*2);
    }

    @Test(timeout = 3000)
    //@Test
    public void testCase3() throws InterruptedException {
        System.out.println("Running test case 3");
        assertEquals(4, 2*2);
        System.out.println(Thread.currentThread().getName());
        TimeUnit.SECONDS.sleep(10);
    }


    @Test(expected = ArithmeticException.class)
    public void expectedException(){
        int a = 1/0;
    }
}
