package Exercise_1.Structural.Facade;

public class Amplifier {
    private int volume;

    public void on() { System.out.println("Amplifier is on"); }
    public void off() { System.out.println("Amplifier is off"); }
    public void setVolume(int level) {
        this.volume = level;
        System.out.println("Amplifier volume set to " + level);
    }
    public int getVolume() { return volume; }
}
