package models;

public class LatestWeather {

    public static double tempF (double tempC) {
        double tempF;
        tempF = (tempC * 1.8) + 32;
        return tempF;
    }
}
