package Exercise_1.Behavioral.Observer;

/**
 * Demonstrates the Observer Pattern with a Weather Station example.
 */
public class Main {
    public static void main(String[] args) {

        System.out.println("=== Observer Pattern Demo (Weather Station Example) ===");

        WeatherStation station = new WeatherStation();// Create subject

        Observer tvDisplay = new DisplayDevice("TV Display");// Create observers (display devices)
        Observer mobileApp = new DisplayDevice("Mobile App");
        Observer digitalBoard = new DisplayDevice("Digital Board");

        station.registerObserver(tvDisplay);// Register observers
        station.registerObserver(mobileApp);
        station.registerObserver(digitalBoard);

        station.setWeatherData("Temperature: 28°C, Humidity: 65%");// Push weather updates
        station.setWeatherData("Temperature: 30°C, Humidity: 70%");

        station.removeObserver(mobileApp);// Remove one observer

        station.setWeatherData("Temperature: 25°C, Humidity: 60%");// Another update
    }
}
