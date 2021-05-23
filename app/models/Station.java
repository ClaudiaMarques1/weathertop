package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class Station extends Model {

    public String name;
    public double lat;
    public double lng;
    @OneToMany(cascade = CascadeType.ALL)
    public List<Reading> readings = new ArrayList<Reading>();

    public String beaufortConversion;
    public String weatherCodes;
    public double windChill;
    public String windDirection;
    public double shortestReadingTemp;
    public double longestReadingTemp;
    public double shortestReadingPressure;
    public double longestReadingPressure;
    public double shortestReadingWind;
    public double longestReadingWind;
    public double latestTemperatureF;
    public double latestTemperatureC;
    public double tempC;
    public double tempF;
    public double latestPressure;
    public double pressure;
    public double windSpeed;

    public Station(String name, double lat, double lng) {
        this.name = name;
        this.lat = lat;
        this.lng = lng;
    }

}