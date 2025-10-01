package Exercise_1.Behavioral.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * WeatherStation acts as the concrete subject.
 * It maintains weather data and notifies all observers when data changes.
 */

public class WeatherStation implements Subject {
    private List<Observer> observers;
    private String weatherData;

    public WeatherStation() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers(String weatherData) {
        for (Observer observer : observers) {
            observer.update(weatherData);
        }
    }

    public void setWeatherData(String weatherData) {
        this.weatherData = weatherData;
        System.out.println("\n[WeatherStation] New Weather Update: " + weatherData);
        notifyObservers(weatherData);
    }
}
