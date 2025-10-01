package Exercise_1.Structural.Facade;

public class DVDPlayer {
    public void on() { System.out.println("DVD Player is on"); }
    public void off() { System.out.println("DVD Player is off"); }
    public void play(String movie) { System.out.println("DVD Player is playing \"" + movie + "\""); }
    public void stop() { System.out.println("DVD Player stopped"); }
    public void eject() { System.out.println("DVD ejected"); }
    public void pause() { System.out.println("DVD Player paused"); }
}
