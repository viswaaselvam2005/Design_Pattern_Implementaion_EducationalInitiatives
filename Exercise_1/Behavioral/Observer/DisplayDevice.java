package Exercise_1.Behavioral.Observer;

/**
 * DisplayDevice acts as the concrete observer.
 * It shows the updated weather data received from the WeatherStation.
 */
public class DisplayDevice implements Observer {
    private String deviceName;

    public DisplayDevice(String deviceName) {
        this.deviceName = deviceName;
    }

    @Override
    public void update(String weatherData) {
        System.out.println(deviceName + " displays: " + weatherData);
    }
}
