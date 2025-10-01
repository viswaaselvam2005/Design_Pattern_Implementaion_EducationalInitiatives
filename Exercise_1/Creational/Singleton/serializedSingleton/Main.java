package Exercise_1.Creational.Singleton.serializedSingleton;

import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        SerializedSingleton instance1 = SerializedSingleton.getInstance();

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("singleton.obj"));
        out.writeObject(instance1);
        out.close();

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("singleton.obj"));
        SerializedSingleton instance2 = (SerializedSingleton) in.readObject();
        in.close();

        System.out.println("Instance 1 hashcode: " + instance1.hashCode());
        System.out.println("Instance 2 hashcode: " + instance2.hashCode());
        System.out.println("Are both same instance? " + (instance1 == instance2));
    }
}