# AlgorithmSuiteX
Welcome to AlgorithmSuiteX! This is an application that can be used to compare and experiment with algorithms across different categories. So far, the current focus is on classic algorithms in computer science (sorting, searching, graph algorithms, etc), but in the future, I intend to expand this to other domains of computer science, including cryptography and machine learning.

Currently the project is a framework of different sorting algorithms without any interface. An interface is planned for the first release. The choice of language for this project is Java, but I also intend to rewrite some scalable algorithms in other languages to compare language performance.
## Tools used in AlgorithmSuiteX
The tools that have been used for the development of the AlgorithmSuiteX project include:
- Eclipse: Integrated Project Support Environment (IPSE)
- Maven: Java Project Management Tool
- Git: Version Control System
- Checkstyle: Code Standards Checker, configured with Google's coding standards (with one slight modification to Javadoc comments)
## How to run
This repository is a Maven project, meaning that it is managed by the Maven project management tool. You do not need Maven installed on your machine as I have included a wrapper in the project for ease of use. All you need to configure is your `JAVA_HOME` environment variable on your operating system to be set to the path of a JDK installed on your machine (a JRE will not work, as it is missing a compiler).

To compile and execute the unit tests, open a terminal window and execute the following command below.
```bash
./mvnw clean test
```