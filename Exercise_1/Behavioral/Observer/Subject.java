package Exercise_1.Behavioral.Observer;
/**
 * Subject interface – WeatherStation implements this.
 */
public interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers(String weatherData);
}

