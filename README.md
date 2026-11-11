# AlgoChallenges

A collection of algorithmic problems and solutions implemented in Java, with automated tests using JUnit 5.

The project focuses on practicing algorithms, data structures, problem-solving techniques, and writing clean, maintainable Java code.

## Tech Stack

- Java 25
- Maven
- JUnit 5
- GitHub Actions

## Project Structure

```text
algochallenges/
├── .github/
│   └── workflows/
│       └── maven.yml
├── .mvn/
│   └── wrapper/
├── src/
│   ├── main/java/
│   └── test/java/
├── .gitignore
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md
```

## Building and Testing

**Requirements:** JDK 25 or later.

The project uses Maven Wrapper, so a separate Maven installation is not required.

Run all tests:

```bash
./mvnw clean test
```

Run the complete Maven verification lifecycle:

```bash
./mvnw clean verify
```

On Windows, use `mvnw.cmd` instead of `./mvnw`.

## Topics Covered

- Arrays and Strings
- Hash Tables
- Binary Search
- Trees and Graphs
- Dynamic Programming
- Greedy Algorithms
- Heaps and Priority Queues
- Advanced Data Structures

## Continuous Integration

GitHub Actions automatically builds the project and executes JUnit tests on every push and pull request.

## Project Goals

- Improve algorithmic problem-solving skills
- Explore efficient data structures and algorithms
- Practice writing readable Java code
- Validate solutions with automated tests
- Maintain a reproducible build process
