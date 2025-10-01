package Exercise_1.Structural.Facade;

public class Lights {
    private int level = 100;
    public void dim(int level) {
        this.level = level;
        System.out.println("Lights dimmed to " + level + "%");
    }
    public void on() {
        this.level = 100;
        System.out.println("Lights are on");
    }
    public int getLevel() { return level; }
}
