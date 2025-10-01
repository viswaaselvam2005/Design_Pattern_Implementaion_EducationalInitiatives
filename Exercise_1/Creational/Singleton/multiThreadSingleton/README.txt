Pattern Name:
Multithread Singleton Pattern Category: Exercise_1.Creational (Singleton)

Description:
- Deals with the Object creation using synchronised function that executes one thread at a time
- This pattern ensures that only one instance of the class is created and used.

Usecase:
-Suppose we are building a web application that serves hundreds of users simultaneously.
-The application needs to connect to a database.
-Creating a new database connection for every request is expensive and can overload the database.

Drawbacks:
- Though this class avoids multithread problem, there is a scenario where the Object occupies space even when the Class's properties aren't used.

To overcome this issue:
-Using a synchronized method simplifies thread safety by allowing only one thread to create the instance at a time, while other threads wait.
-However, synchronizing the entire method can reduce performance, because every call to getInstance() has to acquire the lock, even after the instance is already created.
