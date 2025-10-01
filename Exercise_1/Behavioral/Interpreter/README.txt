# Interpreter Pattern

**Pattern Category:** Behavioral Design Pattern

---

## Description

- The Interpreter pattern provides a way to **evaluate language grammar or expressions**.  
- It defines a representation for grammar along with an **interpreter** that uses the representation to interpret sentences.  
- Think of it like a **calculator** that can understand and evaluate mathematical expressions.  
- Useful when you need to interpret a **simple language or grammar**.  

**Key Idea:**  
> "Define a grammar representation and provide an interpreter to evaluate expressions in that grammar."

---

## The Problem

- Need to interpret **expressions in a simple language**.  
- Want to represent **grammar rules as objects**.  
- Need to evaluate expressions without **hardcoding the logic**.  
- Want to **extend the language** with new grammar rules.  
- Need to **parse and interpret structured data**.

---

## The Solution

- Create an **abstract syntax tree (AST)** representing the grammar.  
- Define an **Expression interface** with an `interpret()` method.  
- Create **terminal expressions** for basic elements.  
- Create **non-terminal expressions** for operations.  
- Use a **parser** to build the AST from input strings.

---

## Code Flow Explanation – Boolean Expression Interpreter

**What This Example Does:**  

- Demonstrates a simple **boolean expression interpreter** that can parse and evaluate expressions like `"true AND false"`, `"true OR false"`, and `"NOT true"` using an AST of expressions.

**Step-by-Step Code Flow:**

- **Expression Interface (`Expression.java`)**  
  - Defines the contract for all expressions  
  - `interpret()` returns the evaluated boolean result  
  - Represents the abstract expression  

- **TerminalExpression Class (`TerminalExpression.java`)**  
  - Represents boolean literals (`true` or `false`) or named constants  
  - `interpret()` returns the stored boolean value or checks the context string  
  - Leaf nodes in the expression tree  

- **AndExpression Class (`AndExpression.java`)**  
  - Non-terminal expression for logical AND  
  - `interpret()` returns `expr1 AND expr2`  
  - Internal nodes in the AST  

- **OrExpression Class (`OrExpression.java`)**  
  - Non-terminal expression for logical OR  
  - `interpret()` returns `expr1 OR expr2`  
  - Internal nodes in the AST  

- **NotExpression Class (`NotExpression.java`)**  
  - Non-terminal expression for logical NOT  
  - `interpret()` returns `NOT expr`  
  - Internal nodes in the AST  

- **InterpreterApplication Class (`InterpreterApplication.java`)**  
  - Builds the expression tree (AST) for different rules  
  - Combines terminal and non-terminal expressions and evaluates them against a context string  
  - Client that parses and evaluates boolean expressions

---

## Real-World Example: Mathematical Expression Calculator

Imagine building a calculator application that:  

- Supports mathematical expressions  
- Can parse different notation formats  
- Allows users to define custom operations  
- Needs to evaluate expressions efficiently  
- Should be extensible for new operations  

**Without Interpreter Pattern:**  
- Complex parsing logic, hardcoded evaluation rules, and difficulty adding new operations  

**With Interpreter Pattern:**  
- Easily add new operations, parse different formats, and maintain clean separation of concerns  

---

## Benefits

- **Extensibility:** Easy to add new grammar rules  
- **Maintainability:** Grammar rules are represented as objects  
- **Separation of Concerns:** Parsing and evaluation are separate  
- **Reusability:** Expression objects can be reused  
- **Flexibility:** Can support different input formats  

---

## Use Cases

- **Mathematical Expressions:** Evaluating formulas  
- **Query Languages:** Interpreting database queries  
- **Configuration Files:** Parsing configuration syntax  
- **Domain-Specific Languages:** Interpreting custom languages  
- **Rule Engines:** Evaluating business rules  

---

## Drawbacks

- **Complexity:** Can become complex for large grammars  
- **Performance:** May be slower than direct evaluation  
- **Learning Curve:** Understanding AST structure  
- **Memory Usage:** Creates many objects for complex expressions  

---

## How to Execute the Code

1. Navigate to the interpreter folder in terminal:  
   ```bash
   cd behavioural/Interpreter
