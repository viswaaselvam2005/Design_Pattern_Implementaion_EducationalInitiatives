Pattern Name:
Interpreter Pattern Category:

Description:
- The Interpreter pattern provides a way to evaluate language grammar or expressions.
- It defines a representation for grammar along with an interpreter that uses the representation to interpret sentences.
 - Think of it like a calculator that can understand and evaluate mathematical expressions.
 - It's useful when you need to interpret a simple language or grammar.

The key idea is: - "Define a grammar representation and provide an interpreter to evaluate expressions in that grammar."

The Problem:
- You need to interpret expressions in a simple language.
- You want to represent grammar rules as objects.
- You need to evaluate expressions without hardcoding the logic.
- You want to extend the language with new grammar rules.
- You need to parse and interpret structured data.

The Solution:
 - Create an abstract syntax tree (AST) representing the grammar.
 - Define an Expression interface with an interpret() method.
 - Create terminal expressions for basic elements.
 - Create non-terminal expressions for operations.
 - Use a parser to build the AST from input strings.

Code Flow Explanation – Boolean Expression Interpreter

What This Example Does:
This example demonstrates a simple boolean expression interpreter that can parse and evaluate expressions like "true AND false", "true OR false", and "NOT true"
using an abstract syntax tree (AST) of expressions.

Step-by-Step Code Flow:

Expression Interface (Expression.java):
Purpose: Defines the contract for all expressions
Method: interpret() returns the evaluated boolean result
Represents: The abstract expression

TerminalExpression Class (TerminalExpression.java):
Purpose: Terminal expression representing boolean literals (true or false) or named constants (Robert, Julie)
Behavior: interpret() returns the stored boolean value or checks the context string
Represents: Leaf nodes in the expression tree

AndExpression Class (AndExpression.java):
Purpose: Non-terminal expression for logical AND
Behavior: interpret() returns expr1 AND expr2
Represents: Internal nodes in the AST

OrExpression Class (OrExpression.java):
Purpose: Non-terminal expression for logical OR
Behavior: interpret() returns expr1 OR expr2
Represents: Internal nodes in the AST

NotExpression Class (NotExpression.java):
Purpose: Non-terminal expression for logical NOT
Behavior: interpret() returns NOT expr
Represents: Internal nodes in the AST

InterpreterApplication Class (InterpreterApplication.java):
Purpose: Builds the expression tree (AST) for different rules
Behavior: Combines terminal and non-terminal expressions and evaluates them against a context string
Represents: The client that parses and evaluates boolean expressions

Real-World Example: Mathematical Expression Calculator

-Imagine you're building a calculator application that:
-Supports mathematical expressions
-Can parse different notation formats
-Allows users to define custom operations
-Needs to evaluate expressions efficiently
-Should be extensible for new operations

Without Interpreter Pattern: You'd need complex parsing logic, hardcoded evaluation rules, and difficulty adding new operations!

With Interpreter Pattern: You can easily add new operations, parse different formats, and maintain clean separation of concerns!

Benefits:

-Extensibility: Easy to add new grammar rules
-Maintainability: Grammar rules are represented as objects
-Separation of Concerns: Parsing and evaluation are separate
-Reusability: Expression objects can be reused
-Flexibility: Can support different input formats

Use Cases:

-Mathematical Expressions: Evaluating mathematical formulas
-Query Languages: Interpreting database queries
-Configuration Files: Parsing configuration syntax
-Domain-Specific Languages: Interpreting custom languages
-Rule Engines: Evaluating business rules

Drawbacks:

-Complexity: Can become complex for large grammars
-Performance: May be slower than direct evaluation
-Learning Curve: Understanding AST structure
-Memory Usage: Creates many objects for complex expressions

How to Execute the Code:
Navigate to the interpreter folder in terminal: cd behavioural/Interpreter
Compile all Java files: javac *.java
Run the main program: java InterpreterApplication

Expected-Output:

John is male? true
Julie is a married woman? true
Robert is NOT married? true
Julie is NOT married? false

Key Takeaways:

-Grammar Representation: Grammar rules are represented as objects
-AST Structure: Expressions form a tree structure
-Terminal vs Non-terminal: Different types of expressions
-Parser Role: Parser builds the expression tree
-Interpretation: Each expression knows how to evaluate itself

Interpreter Pattern Structure:

-Expression Interface: Defines interpret() method
-Terminal Expressions: Represent basic elements
-Non-terminal Expressions: Represent operations
-Context: Contains global information
-Parser: Builds the expression tree

Simple Analogy: Think of it like a language translator:

-Grammar Rules = Expression classes (how to understand the language)
-Sentences = Input strings to interpret
-Translation = interpret() method that evaluates expressions
-Dictionary = Parser that understands the structure
-Result = Understanding and evaluation of the input
