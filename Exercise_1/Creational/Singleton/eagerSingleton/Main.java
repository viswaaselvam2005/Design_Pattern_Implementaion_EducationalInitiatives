package Exercise_1.Creational.Singleton.eagerSingleton;

public class Main {
    public static void main(String[] args) {
        EagerSingleton s1 = EagerSingleton.getInstance();
        s1.showMessage();

        EagerSingleton s2 = EagerSingleton.getInstance();
        s2.showMessage();

        System.out.println("Are both instances same? " + (s1 == s2));
    }
}