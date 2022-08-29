package be.digitalcity.tu.pluralSightCourses.PS_OOP;

public class AircraftNestedClass {
    private final int altitudeF1;
    private final boolean isTvsmCapable;

    public AircraftNestedClass(int altitudeF1, boolean isTvsmCapable) {
        this.altitudeF1 = altitudeF1;
        this.isTvsmCapable = isTvsmCapable;
    }

    // ================ Class Interne ===============
//    public class VerticalSeparation{
//        private int separationInFeet;
//
//        VerticalSeparation(){
//            if(altitudeF1>= 290 && altitudeF1<= 410 && isTvsmCapable) separationInFeet = 1000;
//                    else separationInFeet= 2000 ;
//        }
//        public int getSeparationInFeet(){
//            return separationInFeet;
//        }
//    }

    public int getSeparationInFeet(){
        // ================ Class Interne (LOCAL) ===============
        class VerticalSeparation{
            private int separationInFeet;

            VerticalSeparation(){
                if(altitudeF1>= 290 && altitudeF1<= 410 && isTvsmCapable) separationInFeet = 1000;
                else separationInFeet= 2000 ;
            }
            public int getSeparationInFeet(){
                return separationInFeet;
            }
        }

        VerticalSeparation vsep = new VerticalSeparation();
        return vsep.getSeparationInFeet();

    }
}
