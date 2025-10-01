Pattern Name:
Serialized Singleton Pattern Category:

Description:
- This is a special type of singleton that can be saved to a file and loaded back later.
- It ensures that even when you save the object to a file and read it back, you still get the same single instance.
- Think of it like taking a photo of your singleton object
- when you look at the photo later, it's still the same object.

What is Serialization?
- Serialization means converting an object into a format that can be saved to a file or sent over a network.
- Deserialization means reading that saved format back into an object.
- It's like saving a document to your computer and opening it later.

The Problem:
- When you save a regular singleton object to a file and read it back, Java creates a NEW object.
- This breaks the singleton rule of having only one instance.
- It's like taking a photo of your car, but when you look at the photo, you get a different car!

The Solution:
- We use the readResolve() method to tell Java: "When you read this object back, don't create a new one
- use the existing singleton instance instead."
- This ensures we always get the same instance, even after saving and loading.

Use Case:
- When you need to save your singleton object to a file (like saving user settings).
- When you need to send your singleton object over a network.
- When you want to persist (save) your singleton across program restarts.

Key Features:
- Implements Serializable interface (allows saving to file).
- Uses eager initialization (creates instance immediately).
- Has readResolve() method to maintain singleton behavior.
- Thread-safe by default (eager initialization).

How it Works:
1. Create singleton instance when class loads (eager initialization).
2. When object is saved to file, it's converted to bytes.
 3. When object is read from file, readResolve() method is called.
 4. readResolve() returns the original singleton instance instead of creating a new one.

Advantages:
- Maintains singleton behavior even after serialization.
- Thread-safe (no synchronization needed).
- Simple to implement.
- Can be saved and restored without breaking the pattern.

Drawbacks:
- Creates object even if never used (eager initialization).
- Requires understanding of serialization concepts.
- Slightly more complex than basic singleton.

How to execute the code:
- Go to the file path in the terminal - javac *.java // to compile all the java files
- java Main.java // to run the main file
- Check the output to see that both instances are the same even after saving and loading.