package be.digitalcity.tu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IbanTestValidity {

    Iban iban;

    @Test
    void testValideIban() throws IbanExeption {
        // ARRANGE
        iban = new Iban("BE76377084366795");

        //ASSERT
        assertTrue(iban.isValide());
    }

    @Test
    void testInvalideIban() throws IbanExeption {
        // ARRANGE
        iban = new Iban("BE76377784366795");

        //ASSERT
        assertFalse(iban.isValide());
    }

    @Test
    void testNotBelgianIban0() throws IbanExeption {
        // ARRANGE
        iban = new Iban("UK76377084366795");

        //ASSERT
        IbanExeption exeption = assertThrows(IbanExeption.class, iban::isValide);
        assertEquals("ceci n'est pas un Iban Belge", exeption.getMessage());
    }

    @Test
    void testInvalidFormatIban1() throws IbanExeption {
        // ARRANGE
        iban = new Iban("BE763770843665");

        //ASSERT
        IbanExeption exeption = assertThrows(IbanExeption.class, iban::isValide);
        assertEquals("Le Iban doit etre composer des 16 caractere", exeption.getMessage());
    }

    @Test
    void testInvalidFormatIban2() throws IbanExeption {
        // ARRANGE
        iban = new Iban("BE7637778OuC6795");

        //ASSERT
        IbanExeption exeption = assertThrows(IbanExeption.class, iban::isValide);
        assertEquals("Le Iban doit etre composer de deux lettre majuscule suivis de 14 chiffre", exeption.getMessage());
    }

}
