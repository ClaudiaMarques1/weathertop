package utils;

import models.Reading;

import java.util.List;

public class StationAnalytics {

    public static double getShortestReadingT(List<Reading> readings) {
        Reading shortestReading = null;
        if (readings.size() > 0) {
            shortestReading = readings.get(0);
            for (Reading reading : readings) {
                if (reading.temperature < shortestReading.temperature) {
                    shortestReading = reading;
                    System.out.println("Smallest Temperature is: " + shortestReading.temperature);
                }
            }
        }
        return shortestReading.temperature;
    }

    public static double getLongestReadingT(List<Reading> readings) {
        Reading longestReading = null;
        if (readings.size() > 0) {
            longestReading = readings.get(0);
            for (Reading reading : readings) {
                if (reading.temperature > longestReading.temperature) {
                    longestReading = reading;
                    System.out.println("Largest Temperature is: " + longestReading.temperature);
                }
            }
        }
        return longestReading.temperature;
    }

        public static double getLatestTemperatureC(List<Reading> readings){
        double latestTemperatureC = 0;
        if (readings.size() > 0) {
        Reading lastReading = readings.get(readings.size() - 1);
        latestTemperatureC = lastReading.temperature;
        System.out.println("Latest TemperatureC is: " + latestTemperatureC);
  }
  return latestTemperatureC;
}

    public static double getLatestTemperatureF(List<Reading> readings, double latestTemperatureC) {
        double latestTemperatureF = 0;
        if (readings.size() > 0) {
            Reading lastReading = readings.get(readings.size() - 1);
            latestTemperatureC = lastReading.temperature;
            latestTemperatureF = (latestTemperatureC * 1.8) + 32;
            System.out.println("Latest TemperatureF is: " + latestTemperatureF);
        }
        return latestTemperatureF;
    }

    public static int getLatestPressure(List<Reading> readings) {
        int latestPressure = 0;
        if (readings.size() > 0) {
            Reading lastReading = readings.get(readings.size() - 1);
            latestPressure = lastReading.pressure;
            System.out.println("Latest Pressure is: " + latestPressure);
        }
        return latestPressure;
    }

    public static double getShortestReadingP(List<Reading> readings) {
        Reading shortestReading = null;
        if (readings.size() > 0) {
            shortestReading = readings.get(0);
            for (Reading reading : readings) {
                if (reading.pressure < shortestReading.pressure) {
                    shortestReading = reading;
                    System.out.println("Smallest Pressure Reading is: " + shortestReading.pressure);
                }
            }
        }
        return shortestReading.pressure;
    }

    public static double getLongestReadingP(List<Reading> readings) {
        Reading longestReading = null;
        if (readings.size() > 0) {
            longestReading = readings.get(0);
            for (Reading reading : readings) {
                if (reading.pressure > longestReading.pressure) {
                    longestReading = reading;
                    System.out.println("Largest Pressure Reading is: " + longestReading.pressure);
                }
            }
        }
        return longestReading.pressure;
    }

    public static double getShortestReadingW(List<Reading> readings) {
        Reading shortestReading = null;
        if (readings.size() > 0) {
            shortestReading = readings.get(0);
            for (Reading reading : readings) {
                if (reading.windSpeed < shortestReading.windSpeed) {
                    shortestReading = reading;
                    System.out.println("Smallest Wind Reading is: " + shortestReading.windSpeed);
                }
            }
        }
        return shortestReading.windSpeed;
    }

    public static double getLongestReadingW(List<Reading> readings) {
        Reading longestReading = null;
        if (readings.size() > 0) {
            longestReading = readings.get(0);
            for (Reading reading : readings) {
                if (reading.windSpeed > longestReading.windSpeed) {
                    longestReading = reading;
                    System.out.println("Largest Wind Reading is: " + longestReading.windSpeed);
                }
            }
        }
        return longestReading.windSpeed;
    }
}