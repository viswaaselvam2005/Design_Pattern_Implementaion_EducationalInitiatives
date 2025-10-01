package Exercise_1.Structural.Facade;

public class MusicPlayer {
    public void on() { System.out.println("Music Player is on"); }
    public void off() { System.out.println("Music Player is off"); }
    public void play(String track) { System.out.println("Music Player is playing \"" + track + "\""); }
    public void stop() { System.out.println("Music Player stopped"); }
}
