package Exercise_1.Structural.Facade;

public class HomeTheaterFacade {
    private Amplifier amp;
    private DVDPlayer dvd;
    private Projector projector;
    private Screen screen;
    private Lights lights;
    private MusicPlayer music;

    public HomeTheaterFacade() {
        this.amp = new Amplifier();
        this.dvd = new DVDPlayer();
        this.projector = new Projector();
        this.screen = new Screen();
        this.lights = new Lights();
        this.music = new MusicPlayer();
    }

    // High-level method to watch a movie
    public void watchMovie(String movie) {
        System.out.println("=== Get ready to watch a movie ===");
        lights.dim(20);
        screen.down();
        projector.on();
        projector.wideScreenMode();
        amp.on();
        amp.setVolume(5);
        dvd.on();
        dvd.play(movie);
    }

    // Pause the movie
    public void pauseMovie() {
        System.out.println("=== Pausing the movie ===");
        dvd.pause();
    }

    // End the movie
    public void endMovie() {
        System.out.println("=== Shutting movie theater down ===");
        dvd.stop();
        dvd.eject();
        dvd.off();
        amp.off();
        projector.off();
        screen.up();
        lights.on();
    }

    // Listen to music
    public void listenToMusic(String track) {
        System.out.println("=== Get ready to listen to music ===");
        lights.dim(50);
        amp.on();
        amp.setVolume(7);
        music.on();
        music.play(track);
    }

    public void stopMusic() {
        System.out.println("=== Stopping music ===");
        music.stop();
        music.off();
        amp.off();
        lights.on();
    }

    // Adjust lights
    public void dimLights(int level) {
        System.out.println("=== Adjusting lights ===");
        lights.dim(level);
    }

    // Adjust volume
    public void setVolume(int level) {
        System.out.println("=== Adjusting volume ===");
        amp.setVolume(level);
    }
}

