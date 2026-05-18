# LibrarySystem

![Java](https://img.shields.io/badge/language-Java-orange.svg)
![License](https://img.shields.io/badge/license-GPLv3-blue.svg)

A straightforward library system developed in Java, designed to manage books and their details. This command-line application provides basic functionalities for a library, focusing on simplicity and ease of use.

## 🚀 Key Features & Benefits

*   **Book Management**: Easily add, view, and potentially remove different types of books.
*   **Physical Book Tracking**: Specific handling for physical book details, implying the ability to distinguish between different book formats or attributes.
*   **Data Persistence**: All library data is saved and loaded using a `data.json` file, ensuring that your information is not lost between sessions.
*   **Simple Console Interface**: Interact with the system directly through your terminal, making it lightweight and accessible.
*   **Modular Design**: Structured with classes like `Book`, `PhysicalBook`, `Functions`, and `Main` for clear organization and maintainability.

## 🛠️ Prerequisites & Dependencies

Before you begin, ensure you have the following installed on your system:

*   **Java Development Kit (JDK)**: Version 8 or higher is recommended.
    *   [Download JDK](https://www.oracle.com/java/technologies/downloads/)
*   **`org.json.jar`**: A library for working with JSON data in Java. This dependency should be in the same directory as the `/bin` folder.

## 📦 Installation & Setup Instructions

Follow these steps to get the LibrarySystem up and running on your local machine:

1.  **Clone the Repository**:
    ```bash
    git clone https://github.com/giomilas/LibrarySystem.git
    cd LibrarySystem
    ```

2.  **Compile the Source Code**:
    Navigate to the project root directory and compile the Java source files. Ensure that `org.json.jar` is included in the classpath for compilation.

    ```bash
    javac -cp bin/org.json.jar src/*.java -d bin/
    ```
    This command compiles all `.java` files from the `src/` directory and places the resulting `.class` files into the `bin/` directory.

## 🚀 Usage Examples

To run the LibrarySystem, execute the `Main` class from the `bin/` directory, ensuring `org.json.jar` is on the classpath.

1.  **Run the Application**:
    From the project root directory:
    ```bash
    java -cp bin:bin/org.json.jar Main
    ```

    Upon running, the application will typically present a menu or a prompt in the console, allowing you to interact with the library system.

2.  **Interacting with the System**:
    *   The `Main` class serves as the entry point, coordinating interactions.
    *   `Functions` likely contains the core logic for adding, viewing, and managing books.
    *   `Book` and `PhysicalBook` are data models for the books in the system.
    *   All data will be persistently stored in `data.json`. If `data.json` does not exist, it will likely be created upon the first save operation or initialized by the system.

## ⚙️ Configuration Options

The primary configuration and data storage for this system is managed through the `data.json` file.

*   **`data.json`**: This JSON file, located in the root directory, stores all the book information added to the library system. You can manually inspect or edit this file (though direct editing is not recommended while the application is running) to see the persistent data. The structure of this file will reflect the `Book` and `PhysicalBook` objects.

## 👋 Contributing Guidelines

We welcome contributions to the LibrarySystem! If you have suggestions for improvements or new features, please follow these steps:

1.  **Fork the repository**.
2.  **Create a new branch** for your feature or bug fix: `git checkout -b feature/your-feature-name` or `bugfix/issue-description`.
3.  **Make your changes** and ensure the code adheres to existing style.
4.  **Commit your changes** with a clear and descriptive commit message: `git commit -m "feat: Add new feature X"` or `fix: Resolve bug Y`.
5.  **Push your branch** to your forked repository: `git push origin feature/your-feature-name`.
6.  **Open a Pull Request** to the `main` branch of this repository, describing your changes in detail.

## 📄 License Information

This project is licensed under the **GNU General Public License v3.0**. See the [LICENSE](LICENSE) file for more details.

## 🙏 Acknowledgments

*   Thanks to the developers of the `org.json` library for providing a robust and easy-to-use JSON parsing and generation tool for Java.
