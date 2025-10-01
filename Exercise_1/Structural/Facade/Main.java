package Exercise_1.Structural.Facade;

public class Main {
    public static void main(String[] args) {
        HomeTheaterFacade homeTheater = new HomeTheaterFacade();

        homeTheater.watchMovie("Inception");
        System.out.println();
        homeTheater.pauseMovie();
        System.out.println();
        homeTheater.endMovie();
        System.out.println();
        homeTheater.listenToMusic("Bohemian Rhapsody");
        System.out.println();
        homeTheater.dimLights(30);
        homeTheater.setVolume(10);
        System.out.println();
        homeTheater.stopMusic();
    }
}
