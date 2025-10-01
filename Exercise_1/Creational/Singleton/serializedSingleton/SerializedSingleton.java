package Exercise_1.Creational.Singleton.serializedSingleton;

import java.io.*;

// Step 1: Create Singleton class
class SerializedSingleton implements Serializable { // means this class can be saved and restored

    private static final SerializedSingleton instance = new SerializedSingleton();

    private SerializedSingleton() {}

    public static SerializedSingleton getInstance() {
        return instance;
    }

    protected Object readResolve() {
        return instance;
    }
}