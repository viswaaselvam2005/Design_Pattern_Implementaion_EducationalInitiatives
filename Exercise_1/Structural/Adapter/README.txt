Pattern Name: Adapter Pattern Category

Description:
- The Adapter pattern acts as a bridge between two incompatible interfaces.
- It allows objects with incompatible interfaces to work together by wrapping the existing interface.
 - Think of it like a power adapter that lets to plug a US device into a European outlet.
 - It converts the interface of one class into another interface that clients expect.
 - The Adapter pattern acts as a bridge between two incompatible interfaces, allowing them to work together.

 The key idea is:
 - "Make incompatible interfaces work together by creating a bridge between them."


The Problem:
 - We have an existing class with an interface that doesn't match what we need.
 - We want to use a class that has a different interface than expected.
 - We need to integrate third-party libraries with different interfaces.
 - We want to reuse existing classes without modifying their code.

The Solution:

- Create an Adapter class that implements the target interface.
- The Adapter wraps the existing class and translates calls to it.
- The client code works with the target interface, not the adapted class.
- The Adapter handles the conversion between the two interfaces.


Code Flow Explanation – Document Reader Adapter:

What This Example Does:
-This example demonstrates how to use the Adapter pattern to make a PDF reader support different document formats.
-The PdfReader can natively read PDF files, but uses adapters to read DOCX and TXT files through existing AdvancedDocumentReader implementations.

Step-by-Step Code Flow:

1. DocumentReader Interface (DocumentReader.java)
Purpose: The target interface that the client expects.
Contains: read(String fileType, String fileName) method.
Represents: The standard interface for reading any type of document.

2. AdvancedDocumentReader Interface (AdvancedDocumentReader.java)
Purpose: The existing/legacy interface that needs to be adapted.
Contains: readDocx(String fileName) and readTxt(String fileName) methods.
Represents: Third-party or existing readers that work only with specific for.

3. Concrete Reader Classes (DocxReader.java, TxtReader.java)
Purpose: Implement the AdvancedDocumentReader interface.
Contains: Specific logic for reading Word (.docx) and Text (.txt) files.
Each class: Handles only its specific document format.

4. DocumentAdapter Class (DocumentAdapter.java)
Purpose: The adapter that bridges the two interfaces.
Implements: DocumentReader interface (target).
Contains: Reference to an AdvancedDocumentReader (adaptee).
Translates: DocumentReader.read() calls into AdvancedDocumentReader methods.

Example:
If client calls read("docx", "file.docx") → adapter forwards it to readDocx("file.docx").
If client calls read("txt", "file.txt") → adapter forwards it to readTxt("file.txt").

5. PdfReader Class (PdfReader.java)
Purpose: The client that uses the DocumentReader interface.
Contains: Logic to handle different file types.
Handles:
-PDF natively (built-in support).
-DOCX and TXT via the DocumentAdapter.
-Unsupported formats return an error message.


Real-World Example:
Document Reader Compatibility
Imagine we're building a document viewer app that:
-Has built-in support for PDF files.
-Wants to add support for DOCX and TXT files.
-Uses third-party libraries for Word and Text reading.
-Needs a unified interface for all file formats.

Without Adapter Pattern
-We would need to modify PdfReader or create separate methods for each file type (e.g., readPdf(), readDocx(), readTxt()).
-leading to tightly coupled and hard-to-maintain code.

With Adapter Pattern
-We create adapters (DocumentAdapter) that translate the unified interface calls into specific third-party calls.
-The code remains clean, maintainable, and extensible: we can add support for more formats (like .odt or .html) just by writing new adapters.

Benefits:
-Compatibility: Makes incompatible interfaces work together
-Reusability: Reuse existing classes without modification
-Single Responsibility: Each adapter handles one specific conversion
-Open/Closed Principle: Easy to add new adapters without changing existing code
-Clean Integration: Integrate third-party libraries seamlessly

Use Cases:
-Legacy System Integration: Connecting old systems with new interfaces
-Third-Party Library Integration: Making external libraries work with your code
-Interface Standardization: Creating consistent interfaces across different systems
-Database Adapters: Supporting different database types with same interface
-API Wrappers: Converting between different API formats

Drawbacks:
-Complexity: Adds extra classes and complexity to the system
-Performance: Small overhead due to additional method calls
-Maintenance: Need to maintain adapters when interfaces change
-Over-Engineering: Can be overkill for simple interface mismatches


How to Execute the Code:
Navigate to the adapter folder in terminal: cd Exercise_1.Structural/Adapter
Compile all Java files: javac *.java
Run the main program: java Main

Expected Output:
=== Adapter Pattern Demo ===
Reading PDF file: research_paper.pdf
Reading Word document: assignment.docx
Reading Text file: notes.txt
Invalid file type: xls not supported

Key Takeaways:
1)Interface Translation:
-Adapter translates calls between incompatible interfaces
2)Wrapper Pattern:
-Adapter wraps the existing class and provides new interface
3)Client Isolation:
-Client code doesn't need to know about the adapted class
4)Extensibility:
-Easy to add new adapters for different interfaces
5)Legacy Integration:
-Perfect for integrating existing systems with new code


Adapter Pattern Structure – Document Reader Example
1)Target Interface: What the client expects
→ DocumentReader
2)Adaptee: The existing class with incompatible interface
→ AdvancedDocumentReader (with concrete classes DocxReader, TxtReader)
3)Adapter: The bridge class that implements target interface
→ DocumentAdapter
4)Client: The code that uses the target interface
→ PdfReader

Simple Analogy: Think of it like a power adapter:
-US Device = Client (expects US interface)
-European Outlet = Adaptee (provides European interface)
-Power Adapter = Adapter (converts between interfaces)
-Result = Device works in different country