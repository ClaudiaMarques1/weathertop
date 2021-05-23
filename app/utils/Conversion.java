package utils;

import models.Reading;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static java.lang.Math.pow;

public class Conversion {
    public static String getBeaufortConversion(List<Reading> readings) {

        String beaufortConversion = null;
        if (readings.size() > 0) {
            for (Reading reading : readings) {
                if (reading.windSpeed < 1) {
                    beaufortConversion = "Calm";
                    System.out.println("Beaufort Conversion: " + beaufortConversion);
                } else if ((reading.windSpeed >= 1) && (reading.windSpeed < 5)) {
                    beaufortConversion = "Light Air";
                    System.out.println("Beaufort Conversion: " + beaufortConversion);
                } else if ((reading.windSpeed >= 6) && (reading.windSpeed < 11)) {
                    beaufortConversion = "Light Breeze";
                    System.out.println("Beaufort Conversion: " + beaufortConversion);
                } else if ((reading.windSpeed >= 12) && (reading.windSpeed < 19)) {
                    beaufortConversion = "Gentle Breeze";
                    System.out.println("Beaufort Conversion: " + beaufortConversion);
                } else if ((reading.windSpeed >= 20) && (reading.windSpeed < 28)) {
                    beaufortConversion = "Moderate Breeze";
                    System.out.println("Beaufort Conversion: " + beaufortConversion);
                } else if ((reading.windSpeed >= 29) && (reading.windSpeed < 38)) {
                    beaufortConversion = "Fresh Breeze";
                    System.out.println("Beaufort Conversion: " + beaufortConversion);
                } else if ((reading.windSpeed >= 39) && (reading.windSpeed < 49)) {
                    beaufortConversion = "Strong Breeze";
                    System.out.println("Beaufort Conversion: " + beaufortConversion);
                } else if ((reading.windSpeed >= 50) && (reading.windSpeed < 61)) {
                    beaufortConversion = "Near Gale";
                    System.out.println("Beaufort Conversion: " + beaufortConversion);
                } else if ((reading.windSpeed >= 62) && (reading.windSpeed < 74)) {
                    beaufortConversion = "Gale";
                    System.out.println("Beaufort Conversion: " + beaufortConversion);
                } else if ((reading.windSpeed >= 75) && (reading.windSpeed < 88)) {
                    beaufortConversion = "Severe Gale";
                    System.out.println("Beaufort Conversion: " + beaufortConversion);
                } else if ((reading.windSpeed >= 89) && (reading.windSpeed < 102)) {
                    beaufortConversion = "Strong Storm";
                    System.out.println("Beaufort Conversion: " + beaufortConversion);
                } else if ((reading.windSpeed >= 103) && (reading.windSpeed < 117)) {
                    beaufortConversion = "Strong";
                    System.out.println("Beaufort Conversion: " + beaufortConversion);
                } else {
                    System.out.println("Invalid Beaufort Converison");
                }
            }
        }
        return beaufortConversion;
    }

    public static String getWeatherCodes(List<Reading> readings) {
        String weatherCodes = null;
        if (readings.size() > 0) {
            for (Reading reading : readings) {
                if (reading.code == 100) {
                    weatherCodes = "Clear";
                    System.out.println("Weather Code: " + weatherCodes);
                } else if (reading.code == 200) {
                    weatherCodes = "Partial Clouds";
                    System.out.println("Weather Code: " + weatherCodes);
                } else if (reading.code == 300) {
                    weatherCodes = "Cloudy";
                    System.out.println("Weather Code: " + weatherCodes);
                } else if (reading.code == 400) {
                    weatherCodes = "Light Showers";
                    System.out.println("Weather Code: " + weatherCodes);
                } else if (reading.code == 500) {
                    weatherCodes = "Heavy Showers";
                    System.out.println("Weather Code: " + weatherCodes);
                } else if (reading.code == 600) {
                    weatherCodes = "Rain";
                    System.out.println("Weather Code: " + weatherCodes);
                } else if (reading.code == 700) {
                    weatherCodes = "Snow";
                    System.out.println("Weather Code: " + weatherCodes);
                } else if (reading.code == 800) {
                    weatherCodes = "Thunder";
                    System.out.println("Weather Code: " + weatherCodes);
                } else {
                    System.out.println("Invalid WindSpeed");
                }
            }
        }
        return weatherCodes;
    }

    public static String getWindDirection(List<Reading> readings) {
        String windDirections = null;
        if (readings.size() > 0) {
            for (Reading reading : readings) {
                if ((reading.windDirection > 0) && (reading.windDirection <= 11.25)) {
                    windDirections = "North";
                    System.out.println("Wind Direction: " + windDirections);
                } else if ((reading.windDirection >= 11.26) && (reading.windDirection <= 33.75)) {
                    windDirections = "North North East";
                    System.out.println("Weather Code: " + windDirections);
                } else if ((reading.windDirection >= 33.76) && (reading.windDirection <= 56.25)) {
                    windDirections = "North East";
                    System.out.println("Weather Code: " + windDirections);
                } else if ((reading.windDirection >= 56.26) && (reading.windDirection <= 78.75)) {
                    windDirections = "East North East";
                    System.out.println("Weather Code: " + windDirections);
                } else if ((reading.windDirection >= 78.76) && (reading.windDirection <= 101.25)) {
                    windDirections = "East";
                    System.out.println("Weather Code: " + windDirections);
                } else if ((reading.windDirection >= 101.26) && (reading.windDirection <= 123.75)) {
                    windDirections = "East South East";
                    System.out.println("Weather Code: " + windDirections);
                } else if ((reading.windDirection >= 123.76) && (reading.windDirection <= 146.25)) {
                    windDirections = "South East";
                    System.out.println("Weather Code: " + windDirections);
                } else if ((reading.windDirection >= 146.26) && (reading.windDirection <= 168.75)) {
                    windDirections = "South South East";
                    System.out.println("Weather Code: " + windDirections);
                } else if ((reading.windDirection >= 168.76) && (reading.windDirection <= 191.25)) {
                    windDirections = "South";
                    System.out.println("Weather Code: " + windDirections);
                } else if ((reading.windDirection >= 191.26) && (reading.windDirection <= 213.75)) {
                    windDirections = "South South West";
                    System.out.println("Weather Code: " + windDirections);
                } else if ((reading.windDirection >= 213.76) && (reading.windDirection <= 236.25)) {
                    windDirections = "South West";
                    System.out.println("Weather Code: " + windDirections);
                } else if ((reading.windDirection >= 236.26) && (reading.windDirection <= 258.75)) {
                    windDirections = "West South West";
                    System.out.println("Weather Code: " + windDirections);
                } else if ((reading.windDirection >= 258.76) && (reading.windDirection <= 281.25)) {
                    windDirections = "West";
                    System.out.println("Weather Code: " + windDirections);
                } else if ((reading.windDirection >= 281.26) && (reading.windDirection <= 303.75)) {
                    windDirections = "West North West";
                    System.out.println("Weather Code: " + windDirections);
                } else if ((reading.windDirection >= 303.76) && (reading.windDirection <= 326.25)) {
                    windDirections = "North West";
                    System.out.println("Weather Code: " + windDirections);
                } else if ((reading.windDirection >= 326.26) && (reading.windDirection <= 348.75)) {
                    windDirections = "North North West";
                    System.out.println("Weather Code: " + windDirections);
                } else {
                    System.out.println("Invalid windDirection");
                }
            }
        }
        return windDirections;
    }

    public static double getWindChill(List<Reading> readings) {
        double windChill = 0;
        if (readings.size() > 0) {
            Reading reading = readings.get(readings.size() - 1);
            windChill = 13.12 + 0.6215 * reading.temperature - 11.37 * pow(reading.windSpeed, 0.16) + 0.3965 * reading.temperature * (pow(reading.windSpeed, 0.16));
            windChill = Math.round(windChill * 100) / 100;
            System.out.println("WindChill is: " + windChill);
        }
        return windChill;
    }
}
