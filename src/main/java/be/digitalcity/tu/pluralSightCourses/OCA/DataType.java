package be.digitalcity.tu.pluralSightCourses.OCA;

public class DataType {
    public static void main(String[] args) {

//       sens cast: double > float > long > int > short > byte

        double double0 = 1000;
        byte byte0 = 1;

        float float1 = (float) double0;
        float float2 = byte0;

        long long1 = (long) double0;
        long long2 = byte0;

        int int1 = (int) double0;
        int int2 = byte0;

        short short1 = (short) double0;
        short short2 = byte0;

    }
}
