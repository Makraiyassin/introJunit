package be.digitalcity.tu;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.EnumSet;

import static org.junit.jupiter.api.Assertions.*;

public class ParameterizedTests {
    enum JoursSemaine{
        LUNDI,
        MARDI,
        MERCREDI,
        JEUDI;
    }

    @ParameterizedTest
    @ValueSource(strings = {"lundi","mardi","mercredi","jeudi"})
    void estPresentDansEnum(String jour){
        assertNotNull(JoursSemaine.valueOf(jour.toUpperCase()));
    }

    @ParameterizedTest
    @EnumSource(JoursSemaine.class)
    void estInclusDansEnum1(JoursSemaine  jour){
        assertNotNull(jour);
    }

    @ParameterizedTest
    @EnumSource(names = {"LUNDI","JEUDI"})
    void estInclusDansEnum2(JoursSemaine jour){
        assertTrue(EnumSet.of(JoursSemaine.LUNDI,JoursSemaine.JEUDI).contains(jour));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/jours.csv", delimiter = ',', numLinesToSkip = 1)
    void estInclusDansCsv(String jour, int index){
        assertNotNull(jour);
        assertNotEquals(-1,index);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/jours.csv", delimiter = ',', numLinesToSkip = 1)
    void estInclusDansCsv2(ArgumentsAccessor args){
        Jour j = new Jour();
        j.setName(args.getString(0));
        j.setIndex(args.getInteger(1));

        assertNotNull(j.getName());
        assertNotEquals(-1,j.getIndex());
    }
    static class Jour {
        private String name;
        private int index;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }
    }
}
