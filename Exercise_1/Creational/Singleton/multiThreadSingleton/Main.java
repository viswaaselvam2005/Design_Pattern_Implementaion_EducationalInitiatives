package Exercise_1.Creational.Singleton.multiThreadSingleton;

public class Main {
    public static void main(String[] args) {
        MultiThreadSingleton singleton1 = MultiThreadSingleton.getInstance();
        System.out.println(singleton1);

        MultiThreadSingleton singleton2 = MultiThreadSingleton.getInstance();
        System.out.println(singleton2);

        if(singleton1 == singleton2){
            System.out.println("Singleton works, both variables are the same instance");
        }

        //check if after singleton1 is executed only singleton2 is created, check if it is thread safe
    }
}