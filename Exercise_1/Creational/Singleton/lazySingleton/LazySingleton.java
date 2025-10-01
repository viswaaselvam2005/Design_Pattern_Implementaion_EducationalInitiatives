package Exercise_1.Creational.Singleton.lazySingleton;

class LazySingleton {
    private static LazySingleton instance;

    private LazySingleton() {
        System.out.println("Singleton instance created!");
    }

    public static LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("Hello from Lazy Singleton!");
    }
}
