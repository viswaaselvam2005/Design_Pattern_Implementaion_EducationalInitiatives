Pattern Name:
Lazy Singleton Pattern Category: Exercise_1.Creational (Singleton)

Description:
- Deals with the creation of an Object.
- This pattern ensures that only one instance of the class is created and used.

Usecase:
- Incase if we are connecting to a database, it is a good practice to create one single instance of the DB connection and use the same connection to execute the line of queries instead of establishing a new connection for every query.

Drawbacks:
-Multi-thread problem ,to overcome this problem we can use Eager Initialisation of objects.

How to execute the code:

- go to the file path in the terminal
- javac *.java // to compile all the java files
- java Main.java // to run the main file.