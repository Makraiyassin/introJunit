package be.digitalcity.tu;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TriangleTest {
    Triangle triangle;
    String result;

    @Test
    void testTriangleEquilateral1() throws TriangleExeption {
        // ARRANGE
        triangle = new Triangle(3,3,3);

        //ACT
        result = triangle.getType();

        //ASSERT
        assertEquals("equilateral",result);
    }

    @Test
    void testTriangleEquilateral2() throws TriangleExeption {
        // ARRANGE
        triangle = new Triangle(4,4,4);

        //ACT
        result = triangle.getType();

        //ASSERT
        assertEquals("equilateral",result);
    }

    @Test
    void testTriangleEquilateral3() throws TriangleExeption {
        // ARRANGE
        triangle = new Triangle(5,5,5);

        //ACT
        result = triangle.getType();

        //ASSERT
        assertEquals("equilateral",result);
    }

    @Test
    void testTriangleScalene1() throws TriangleExeption {
        // ARRANGE
        triangle = new Triangle(2,3,4);

        //ACT
        result = triangle.getType();

        //ASSERT
        assertEquals("scalene",triangle.getType());
    }

    @Test
    void testTriangleScalene2() throws TriangleExeption {
        // ARRANGE
        triangle = new Triangle(10,3,12);

        //ACT
        result = triangle.getType();

        //ASSERT
        assertEquals("scalene",result);
    }

    @Test
    void testTriangleScalene3() throws TriangleExeption {
        // ARRANGE
        triangle = new Triangle(3,4,5);

        //ACT
        result = triangle.getType();

        //ASSERT
        assertEquals("scalene",result);
    }

    @Test
    void testTriangleIsocele1() throws TriangleExeption {
        // ARRANGE
        triangle = new Triangle(5,5,3);

        //ACT
        result = triangle.getType();

        //ASSERT
        assertEquals("isocele",result);
    }

    @Test
    void testTriangleIsocele2() throws TriangleExeption {
        // ARRANGE
        triangle = new Triangle(3,3,4);

        //ACT
        result = triangle.getType();

        //ASSERT
        assertEquals("isocele",result);
    }

    @Test
    void testTriangleIsocele3() throws TriangleExeption {
        // ARRANGE
        triangle = new Triangle(6,3,6);

        //ACT
        result = triangle.getType();

        //ASSERT
        assertEquals("isocele",result);
    }

    @Test
    void testTriangleInvalid1() throws TriangleExeption {
        // ARRANGE
        triangle = new Triangle(3,3,10);

        //ASSERT
        TriangleExeption exception = assertThrows(TriangleExeption.class, () -> triangle.getType() );
        assertEquals("Ceci n'est pas un triangle (le plus grand cotes ne doit pas etre plus grand ou egale a la somme des deux autre cotes)",exception.getMessage());
    }

    @Test
    void testTriangleInvalid2() throws TriangleExeption {
        // ARRANGE
        triangle = new Triangle(0,3,10);

        //ASSERT
        TriangleExeption exception = assertThrows(TriangleExeption.class, triangle::getType );
        assertEquals("Ceci n'est pas un triangle (les 3 cotes doivent etre superieur a 0)",exception.getMessage());
    }

    @Test
    void testTriangleInvalid3() throws TriangleExeption {
        // ARRANGE
        triangle = new Triangle(-3,9,4);

        //ASSERT
        TriangleExeption exception = assertThrows(TriangleExeption.class, () -> {
            result = triangle.getType();
        });
        assertEquals("Ceci n'est pas un triangle (les 3 cotes doivent etre superieur a 0)",exception.getMessage());
    }


    @RepeatedTest(value = 100)
    void testTriangleRandom() throws TriangleExeption {
        Random rnd = new Random();
        // ARRANGE
        triangle = new Triangle(rnd.nextInt(10),rnd.nextInt(10), rnd.nextInt(10));

        //ASSERT
//        TriangleExeption exception = assertThrows(TriangleExeption.class, () -> {
//            result = triangle.getType();
//        });
//        assertEquals("Ceci n'est pas un triangle (les 3 cotes doivent etre superieur a 0)",exception.getMessage());
//        assertEquals("Ceci n'est pas un triangle (le plus grand cotes ne doit pas etre plus grand ou egale a la somme des deux autre cotes)",exception.getMessage());

//        assertEquals("equilateral",triangle.getType());

//        assertEquals("isocele",triangle.getType());

//        assertEquals("scalene",triangle.getType());

            assertDoesNotThrow(triangle::getType);  //test combien de fois on obtient un triangle valide
    }
}


