package controllers;

import java.util.List;

import models.Member;
import models.Station;
import models.Reading;
import models.LatestWeather;
import utils.StationAnalytics;
import utils.Conversion;
import play.Logger;
import play.mvc.Controller;

public class Dashboard extends Controller {
    public static void index() {
        Logger.info("Rendering Dashboard");
        Member member = Accounts.getLoggedInMember();
        List<Station> stations = member.stations;

        for (Station station : stations) {
            List<Reading> readings = station.readings;
            if (readings.size() > 0) {
                Reading lastReading = readings.get(readings.size() - 1);
                station.tempC = lastReading.temperature;
                station.tempF = LatestWeather.tempF(lastReading.temperature);
                station.pressure = lastReading.pressure;
                station.windSpeed = lastReading.windSpeed;
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
        }

        render("dashboard.html", stations);
    }

    public static void deleteStation(Long id) {
        Logger.info("Deleting a Station");
        Member member = Accounts.getLoggedInMember();
        Station station = Station.findById(id);
        member.stations.remove(station);
        member.save();
        station.delete();
        redirect("/dashboard");
    }

    public static void addStation(String name, double lat, double lng) {
        Logger.info("Adding a Station");
        Member member = Accounts.getLoggedInMember();
        Station station = new Station(name, lat, lng);
        member.stations.add(station);
        member.save();
        redirect("/dashboard");
    }
}
