package Exercise_1.Creational.Singleton.lazySingleton;

public class Main {
    public static void main(String[] args) {
        LazySingleton s1 = LazySingleton.getInstance();
        s1.showMessage();

        LazySingleton s2 = LazySingleton.getInstance();
        s2.showMessage();

        System.out.println("Are both instances same? " + (s1 == s2));
    }
}