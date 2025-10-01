package Exercise_1.Creational.Singleton.multiThreadSingleton;

public class MultiThreadSingleton{

    private static MultiThreadSingleton instance = null;

    private MultiThreadSingleton(){}

    public static MultiThreadSingleton getInstance(){
        if(instance == null){
            synchronized(MultiThreadSingleton.class){
                if(instance == null){
                    instance = new MultiThreadSingleton(); // this is where the object is actually created.
                }
            }
        }
        return instance;
    }
}