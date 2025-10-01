Pattern Name:
Observer Pattern Category:

Description:
- The Observer pattern defines a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically.
- It establishes a loose coupling between the subject and observers.
- Think of it like a newspaper subscription - when news is published, all subscribers automatically receive it.
- It's useful for implementing event handling systems and maintaining consistency between related objects.

The key idea is:
- "Define a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically."

The Problem:
- You have objects that need to be notified when another object changes.
- You want to maintain consistency between related objects.
- You need to implement event handling systems.
- You want to avoid tight coupling between objects.
- You need to support multiple observers for a single subject.

The Solution:
- Create a Subject interface that manages observers.
- Create an Observer interface that defines the update method.
- Subjects register and notify observers when state changes.
- Observers implement the update method to respond to changes.
- The subject doesn't need to know about specific observer implementations.

Code Flow Explanation:

What This Example Does:
This example demonstrates a weather station system where multiple display devices (observers) automatically receive updates
whenever the weather station (subject) publishes new weather data.

Step-by-Step Code Flow:
1)Subject Interface (Subject.java):

Purpose: Defines the contract for subjects
Methods: registerObserver(), removeObserver(), notifyObservers()
Represents: The weather station being observed

2)Observer Interface (Observer.java):

Purpose: Defines the contract for observers
Method: update() receives weather updates
Represents: Display devices that need to be notified

3)WeatherStation Class (WeatherStation.java)

Purpose: Concrete subject implementation
Behavior: Stores weather data, manages observer list, and notifies them
Contains: List of observers + weather info
Represents: The central weather source

4)DisplayDevice Class (DisplayDevice.java)

Purpose: Concrete observer implementation
Behavior: Displays weather updates when notified
Contains: Device name
Represents: End-user devices like TV, Mobile, Digital Board

Real-World Example: News Broadcasting System

Imagine you're building a news application that:

Has a central news source that publishes stories
Supports multiple news channels and subscribers
Automatically notifies all subscribers of new content
Allows dynamic subscription/unsubscription
Should be scalable and maintainable

Without Observer Pattern: You'd have tight coupling, manual notification systems, and difficulty managing multiple subscribers!

With Observer Pattern: News automatically flows to all subscribers, maintaining loose coupling and easy extensibility!

Benefits:

Loose Coupling:
-Subject and observers are loosely coupled
Automatic Updates:
-Observers are automatically notified of changes
Dynamic Relationships:
-Observers can be added/removed at runtime
Broadcast Communication:
-One change can notify many observers
Extensibility:
-Easy to add new observers without changing subjects

Use Cases:

Event Handling:
-GUI events, system events
Model-View:
-Separating data from presentation
Publish-Subscribe:
-News, social media feeds
Configuration Changes:
-Notifying components of config updates
Sensor Systems:
-Monitoring and alerting systems

Drawbacks:

Memory Leaks:
-Observers must be properly removed
Performance:
-Notifying many observers can be slow
Order Dependency:
-Observer notification order may matter
Unexpected Updates:
-Observers may receive unexpected notifications

How to Execute the Code:
Navigate to the observer folder in terminal: cd Behavioural/Observer
Compile all Java files: javac *.java
Run the main program: java Main

Expected Output:
=== Observer Pattern Demo (Weather Station Example) ===

[WeatherStation] New Weather Update: Temperature: 28°C, Humidity: 65%
TV Display displays: Temperature: 28°C, Humidity: 65%
Mobile App displays: Temperature: 28°C, Humidity: 65%
Digital Board displays: Temperature: 28°C, Humidity: 65%

[WeatherStation] New Weather Update: Temperature: 30°C, Humidity: 70%
TV Display displays: Temperature: 30°C, Humidity: 70%
Mobile App displays: Temperature: 30°C, Humidity: 70%
Digital Board displays: Temperature: 30°C, Humidity: 70%

[WeatherStation] New Weather Update: Temperature: 25°C, Humidity: 60%
TV Display displays: Temperature: 25°C, Humidity: 60%
Digital Board displays: Temperature: 25°C, Humidity: 60%
Disconnected from the target VM, address: '127.0.0.1:62955', transport: 'socket'

Key Takeaways:
Loose Coupling:

-Subject and observers don't know each other's details
Automatic Notification:
-Observers are automatically updated
Dynamic Registration:
-Observers can be added/removed at runtime
Broadcast Communication:
-One change notifies all observers
Event-Driven Architecture:
-Supports event-based programming

Observer Pattern Structure:

Subject Interface:
-Defines observer management methods
Concrete Subject:
-Implements observer management
Observer Interface:
-Defines update method
Concrete Observers:
-Implement update behavior
Client:
-Creates and configures the system


Simple Analogy:

Think of it like a social media platform:
Social Media Platform = Subject (publishes content)
Users = Observers (subscribe to content)
Posts = State changes (trigger notifications)
News Feed = Update method (receives notifications)
Result = All followers automatically see new posts

