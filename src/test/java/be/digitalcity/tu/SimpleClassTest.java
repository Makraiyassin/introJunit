package be.digitalcity.tu;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SimpleClassTest {
    @Test
    void testAdditionBasic() {
        //ARRANGE
        int a = 4;
        int b = 3;
        int result;

        //ACT
        result = a + b;

        //ASSERT
        assertEquals(7, result);
    }

    @Test
    void testConcatenationStringHelloWorldFailed1() {
        //ARRANGE
        String a = "hello";
        String b = "world";
        String result;

        //ACT
        result = a + b;

        //ASSERT
        assertNotEquals("hello world", result);
    }

    @Test
    void testConcatenationStringHelloWorldFailed2() {
        //ARRANGE
        String a = "hello";
        String b = "world";
        String result;

        //ACT
        result = a + b;

        //ASSERT
        assertNotEquals("h ello world", result);
    }

    @Test
    void testConcatenationStringHelloWorldFailed3() {
        //ARRANGE
        String a = "hello";
        String b = "world";
        String result;

        //ACT
        result = a + b;

        //ASSERT
        assertNotEquals("hello  world", result);
    }

    @Test
    void testConcatenationStringHelloWorldFailed4() {
        //ARRANGE
        String a = "hello";
        String b = "world";
        String result;

        //ACT
        result = a + b;

        //ASSERT
        assertNotEquals("hello world ", result);
    }

    @Test
    void testConcatenationStringHelloWorldSucces () {
        //ARRANGE
        String a = "hello";
        String b = "world";
        String result;

        //ACT
        result = a + " " + b;

        //ASSERT
        assertEquals("hello world", result);
    }

    @Test
    void testDivisionZero () {
        //ARRANGE
        int a = 5;

        //ASSERTS
//        Exception exception = assertThrows(ArithmeticException.class, () -> diviseByZero(5));
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            int result = a/0;
        });
        assertEquals( "/ by zero", exception.getMessage());
    }
    public static int diviseByZero(int a){return a/0;}


}

