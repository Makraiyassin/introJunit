package be.digitalcity.tu;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TriangleTest {
    Triangle triangle;
    String result;
    @Test
    void testTriangleScalene1(){
        // ARRANGE
        triangle = new Triangle(1,2,5);

        //ACT
        result = triangle.getType();

        //ASSERT
        assertEquals("scalene",triangle.getType());
    }

    @Test
    void testTriangleScalene2(){
        // ARRANGE
        triangle = new Triangle(10,2,12);

        //ACT
        result = triangle.getType();

        //ASSERT
        assertEquals("scalene",result);
    }

    @Test
    void testTriangleScalene3(){
        // ARRANGE
        triangle = new Triangle(3,4,5);

        //ACT
        result = triangle.getType();

        //ASSERT
        assertEquals("scalene",result);
    }

    @Test
    void testTriangleIsocele1(){
        // ARRANGE
        triangle = new Triangle(2,2,5);

        //ACT
        result = triangle.getType();

        //ASSERT
        assertEquals("isocele",result);
    }

    @Test
    void testTriangleIsocele2(){
        // ARRANGE
        triangle = new Triangle(3,3,4);

        //ACT
        result = triangle.getType();

        //ASSERT
        assertEquals("isocele",result);
    }

    @Test
    void testTriangleIsocele3(){
        // ARRANGE
        triangle = new Triangle(6,3,6);

        //ACT
        result = triangle.getType();

        //ASSERT
        assertEquals("isocele",result);
    }

}


