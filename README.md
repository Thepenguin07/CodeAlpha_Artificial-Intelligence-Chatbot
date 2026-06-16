# CodeAlpha_Artificial-Intelligence-Chatbot

A lightweight, interactive, Java-based desktop chatbot designed to act as an educational assistant for developers learning Java and Object-Oriented Programming (OOP) fundamentals. Developed as part of the CodeAlpha Java Programming Internship (Task 3).

🚀 Features
Desktop GUI Interface: Built entirely using Java Swing (JFrame, JTextArea, JTextField) with a modern, clean color palette and automatic scroll-down functionality.

Natural Language Processing (NLP) Sanitization: Cleans and processes user inputs (lowercase conversion, regex-based punctuation removal) to match user intent accurately.

Smart Rule-Based Logic: Leverages mapped keyword matrices to detect topics such as OOP pillars, interfaces, inheritance, and exception handling.

Dynamic Responses: Utilizes a randomized response generation algorithm to make conversations feel organic and conversational rather than rigid.

Error & Fallback Handling: Safely routes unrecognized queries to a fallback module that guides users back to supported topics.

🛠️ Tech Stack & Concepts Used
Language: Java (JDK 8 or higher)
GUI Framework: Java Swing & AWT (Abstract Window Toolkit)
Data Structures: HashMap for dynamic response routing, ArrayList/Arrays for randomized options.
OOP Concepts: Encapsulation, Event Handling (Action Listeners), and Modular Architecture.

📂 Project Structure
Plaintext
CodeAlpha_ArtificialIntelligenceChatbot/
│
├── src/
│   └── chatbot.java       # Main application source code containing GUI and logic
│
└── README.md              # Project documentation
🎮 How To Run the Application
Prerequisites
Make sure you have the Java Development Kit (JDK) installed on your system. You can check your version by running:
Bash
java -version
Steps to Execute
Clone the Repository:
Bash
git clone https://github.com/YOUR_USERNAME/CodeAlpha_ArtificialIntelligenceChatbot.git
cd CodeAlpha_ArtificialIntelligenceChatbot/src
Compile the Code:
Bash
javac chatbot.java
Run the Chatbot:
Bash
java chatbot
💬 Supported Conversation Topics
Type naturally into the input field to ask the assistant about:
Java Basics: Try typing "What is Java?" or "Tell me about the JVM".
OOP Pillars: Try typing "Explain OOP pillars" or "What is polymorphism?".
Classes & Objects: Try typing "How do classes work?".
Interfaces & Inheritance: Try typing "What is an interface?" or "How does extends work?".
Exception Handling: Try typing "How do I use try catch?".
Help: Type "help" at any point to get a directory of topics.
🤝 Acknowledgments
Special thanks to CodeAlpha for providing the structured framework and mentorship during this internship domain challenge.
