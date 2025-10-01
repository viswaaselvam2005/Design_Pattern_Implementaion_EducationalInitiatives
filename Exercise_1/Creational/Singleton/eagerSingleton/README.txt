Pattern Name:

EagerSingleton Pattern Category: Exercise_1.Creational (Singleton)

Description:
- Deals with the eagerly initialising an Object when the JVM loads the class.
- avoiding the multithread problem.
- This pattern ensures that only one instance of the class is created and used.

Use Case: "Logger System"
-In many applications we need a single global logging mechanism to track events, errors, or debug messages.
-Logging is always required from the very start of the application.
-Using Eager Singleton ensures that the Logger instance is created when the application starts and is available globally, without worrying about thread-safety or delayed initialization.

Drawbacks:
- Though this class avoids multithread problem, there is a scenario where the Object occupies space even when the Class's properties aren't used.

To overcome this issue
- use synchronised function to make the class as synchronised and lets the other thread to wait until the previous completes its execution.
- Works similar to LazySingleton but with a synchronised function.

How to execute the code:

- go to the file path in the terminal
- javac *.java // to compile all the java files
- java Main.java // to run the main file.