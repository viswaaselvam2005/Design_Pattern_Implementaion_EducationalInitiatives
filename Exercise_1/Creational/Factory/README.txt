Pattern name: Factory Method Pattern category

Description:
- The Factory Pattern is like a smart object generator.
- based on the input parameters, the factory design pattern creates an object.
- works on abstarct class or interface
- Instead of creating objects directly using new, we use a factory class or method to decide which object to create.

The key idea is:

    “Let a factory method decide which class to instantiate based on input or condition.”

The problem:
- Unlike Singleton, factory patterns avoids object creation using new clauses.

The solution:
- takes any input as an input parameter
- Internally decides which object has to be created.

Usecase:
-we are building a food ordering system. Based on customer choice, you need to prepare either a Pizza, Burger, or Sandwich.

-Using a Factory, you can abstract this creation and simply say:

Food f = FoodFactory.getFood("Pizza");
f.prepare(); //method respective to food(pizza,burger,sandwich)

-The client code doesn’t need to know which concrete class is being created.
-The factory decides internally.


Drawbacks:
- Overuse can lead to many factory classes and make the design harder to navigate.

How to execute the code:
- go to the file path in the terminal
- javac *.java // to compile all the java files
- java Main.java // to run the main file.

How to Execute the Code:

1)Open a terminal and navigate to the project directory:
-cd path/to/Exercise_2.AstronautDailyScheduler
2)Compile all Java files (including subfolders) using:
-javac */*.java Main.java
3)Run the main application:
-java Main
4)Follow the console prompts to add tasks, mark them complete, or view the schedule.
