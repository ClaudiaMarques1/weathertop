package controllers;

import models.Station;
import models.Reading;
import play.Logger;
import play.mvc.Controller;
import utils.Conversion;
import utils.StationAnalytics;

import java.util.Date;
import java.util.List;


public class StationCtrl extends Controller {

    public static void index(Long id, double latestTemperatureC) {
        Station station = Station.findById(id);
        Logger.info("Station id = " + id);

        List<Reading> readings = station.readings;
        if (readings.size() > 0) {
            station.latestTemperatureC = StationAnalytics.getLatestTemperatureC(station.readings);
            station.latestTemperatureF = StationAnalytics.getLatestTemperatureF(station.readings, latestTemperatureC);
            station.latestPressure = StationAnalytics.getLatestPressure(station.readings);
            station.beaufortConversion = Conversion.getBeaufortConversion(station.readings);
            station.weatherCodes = Conversion.getWeatherCodes(station.readings);
            station.windChill = Conversion.getWindChill(station.readings);
            station.windDirection = Conversion.getWindDirection(station.readings);
            station.shortestReadingTemp = StationAnalytics.getShortestReadingT(station.readings);
            station.longestReadingTemp = StationAnalytics.getLongestReadingT(station.readings);
            station.shortestReadingPressure = StationAnalytics.getShortestReadingP(station.readings);
            station.longestReadingPressure = StationAnalytics.getLongestReadingP(station.readings);
            station.shortestReadingWind = StationAnalytics.getShortestReadingW(station.readings);
            station.longestReadingWind = StationAnalytics.getLongestReadingW(station.readings);
        }
        render("station.html", station);

    }

    public static void deletereading(Long id, Long readingid) {
        Station station = Station.findById(id);
        Reading reading = Reading.findById(readingid);
        Logger.info("Removing" + reading.temperature);
        station.readings.remove(reading);
        station.save();
        reading.delete();
        render("station.html", station);
    }

    public static void addReading(Long id, Date date, int code, double temperature, double windSpeed, int pressure) {
        Reading reading = new Reading(date, code, temperature, windSpeed, pressure);
        Station station = Station.findById(id);
        station.readings.add(reading);
        station.save();
        redirect("/stations/" + id);
    }
}