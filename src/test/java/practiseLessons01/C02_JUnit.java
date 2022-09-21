package practiseLessons01;

import org.junit.*;

public class C02_JUnit {

   @BeforeClass
   public static void sClass(){
       System.out.println("Before Class");
       // Her class'ta ilk ve bir kez calisir
   }
    @Before
    public void setUp(){
        System.out.println("Before");
        // Her testten once bir kez calisir
   }

    @After
    public void tearDown(){
        System.out.println("After");
        // Her testten sonra bir kez calisir
    }

    @AfterClass
    public static void aClass(){
        System.out.println("After Class");
        // Her class'ta son ve bir sefer calisir
    }

    @Test
    public void test01(){
        System.out.println("Test 01");
    }


    @Test
    public void test02(){
        System.out.println("Test 02");
    }


    @Test
    public void test03(){
        System.out.println("Test 03");
    }
}
