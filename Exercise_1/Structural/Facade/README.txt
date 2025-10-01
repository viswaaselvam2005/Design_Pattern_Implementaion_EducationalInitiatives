Pattern Name: Facade Pattern Category

Description:

- The Facade pattern provides a simplified interface to a complex subsystem, making it easier to use.
- It hides the complexity of the subsystem and provides a single entry point for client code.
- Think of it like a receptionist at a hotel.
- you don't need to know about housekeeping, maintenance, or room service details.
- It promotes loose coupling between the client and the subsystem components.

The key idea is:

- "Provide a simple interface to a complex subsystem, hiding its complexity from clients."

The Problem:

- You have a complex subsystem with many classes and dependencies.
- Client code needs to interact with multiple subsystem components.
- The subsystem is difficult to use and understand.
- You want to reduce coupling between client code and subsystem.
- You need to provide a simple interface for common operations.

The Solution:

- Create a Facade class that provides a simplified interface to the subsystem.
- The Facade knows how to work with all the subsystem components.
- Clients only interact with the Facade, not the complex subsystem directly.
- The Facade handles the complexity and coordinates between subsystem components.

Code Flow Explanation:

-What This Example Does:
-This example demonstrates how to use the Facade Pattern to simplify operating a home theater system.
-Instead of dealing with multiple complex components like Amplifier, DVD Player, Music Player, Lights, Screen, and Projector individually.
-the Facade provides simple high-level methods such as:

watchMovie(String movie) – Start a full movie experience
pauseMovie() – Pause the movie
endMovie() – Shut down everything after a movie ends
listenToMusic(String track) – Play music with proper setup
stopMusic() – Stop music playback
dimLights(int level) – Adjust light brightness dynamically
setVolume(int level) – Adjust audio volume dynamically

-The client only interacts with the Facade, and the Facade internally coordinates the subsystems.

1. Subsystem Components:
-Each subsystem class represents a physical device in the home theater.
-These classes contain specific, low-level operations.
Subsystem-Purpose:

Amplifier->Controls audio system and volume.
DVD Player->Handles movie playback.
Music Player->Handles music playback (CD or streaming).
Lights->Manages lighting brightness.
Screen->Controls screen up and down.
Projector->Manages projector power and display modes.

2. HomeTheaterFacade Class:
-The Facade class (HomeTheaterFacade) combines all these subsystems and provides high-level methods.
-The client does not need to know about individual subsystems or how they work together.

Purpose:
-Acts as a single point of control for all devices.
Provides clean, simple methods like:
-watchMovie()
-pauseMovie()
-endMovie()
-listenToMusic()
-stopMusic()

3. Main Program (Client Code):
Purpose: Demonstrates how the client uses the ComputerFacade to perform complex operations easily.
What It Does: Creates a ComputerFacade object and calls simple methods like startComputer(), loadProgram(), and shutdownComputer().
Why Useful: Keeps the code clean by hiding CPU, Memory, and HardDrive complexities.
Flow:
-Create facade object
-Start computer
-Load program
-Backup data
-Restart computer
-Shut down computer
Result: Simple, readable code with all complexity hidden inside the facade.

Real-World Example:
Computer System Interface
Imagine you're building a computer management application that:

-Needs to start up computers (involves CPU, Memory, HardDrive coordination)
-Must load programs (requires HardDrive reading and Memory loading)
-Should back up data (involves HardDrive writing and Memory verification)
-Wants to restart computers (requires shutdown then startup sequence)
-Avoids exposing complex subsystem details to users

Without Facade Pattern:
-Users would need to know about CPU.freeze(), Memory.load(), HardDrive.read(), etc., and coordinate them manually!
With Facade Pattern:
-Users just call computer.startComputer() and the Facade handles all the complexity internally!

Benefits:

Simplicity:
-Provides a simple interface to complex subsystems
Loose Coupling:
-Reduces dependency between client and subsystem
Encapsulation:
-Hides subsystem complexity from clients
Single Responsibility:
-Facade handles subsystem coordination
Easy Maintenance:
-Changes to subsystem don't affect client code

Use Cases:

Computer Systems:
-Simplifying hardware operations
Database Access:
-Providing simple CRUD operations
File Systems:
-Simplifying file operations
Network APIs:
-Providing simple interfaces to complex protocols
Game Engines:
-Simplifying graphics, audio, and input systems

Drawbacks:

God Object:
-Facade can become too large if it handles too many responsibilities
Tight Coupling:
-Facade becomes tightly coupled to the subsystem
Hidden Complexity:
-May hide important subsystem details from clients
Testing:
-Harder to test individual subsystem components in isolation

How to Execute the Code:
Navigate to the facade folder in terminal: cd Exercise_1.Structural/Facade
Compile all Java files: javac *.java
Run the main program: java Main

Expected-Output:

=== Get ready to watch a movie ===
Lights dimmed to 20%
Screen going down
Projector is on
Projector in widescreen mode
Amplifier is on
Amplifier volume set to 5
DVD Player is on
DVD Player is playing "Inception"

=== Pausing the movie ===
DVD Player paused

=== Shutting movie theater down ===
DVD Player stopped
DVD ejected
DVD Player is off
Amplifier is off
Projector is off
Screen going up
Lights are on

=== Get ready to listen to music ===
Lights dimmed to 50%
Amplifier is on
Amplifier volume set to 7
Music Player is on
Music Player is playing "Bohemian Rhapsody"

=== Adjusting lights ===
Lights dimmed to 30%
=== Adjusting volume ===
Amplifier volume set to 10

=== Stopping music ===
Music Player stopped
Music Player is off
Amplifier is off
Lights are on

Key Takeaways:

Simplified Interface:
-Complex operations become simple method calls
Subsystem Encapsulation:
-Hide complexity from client code
Single Entry Point:
-One class handles all subsystem interactions
Loose Coupling:
-Clients don't depend on subsystem details
Coordination:
-Facade coordinates multiple subsystem operations

Facade Pattern Structure:

Subsystem Classes:
-Complex classes with specific responsibilities (CPU, Memory, HardDrive)
Facade Class:
-Provides simplified interface and coordinates subsystem operations
Client:
-Uses the Facade instead of interacting with subsystem directly


Simple Analogy: Think of it like a restaurant:

Kitchen Staff = Subsystem (Chef, Sous Chef, Dishwasher)
Waiter = Facade (takes your order, coordinates with kitchen)
Customer = Client (just tells waiter what they want)
Result = Customer gets food without knowing kitchen complexity
