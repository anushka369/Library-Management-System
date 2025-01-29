# Library Management System 📖

## Introduction
The **Library Management System** is a Java-based GUI application built using **Swing** that allows users to manage books in a library. The system provides functionalities to add, update, search, and remove books. The books are stored in an in-memory data structure (ArrayList of HashMaps).

---

## Features ☀️
- **Add a Book**: Users can add book details including title, author, ISBN, publication year, genre, and availability status.
- **Update a Book**: Users can select a book from the table and update its details.
- **Remove a Book**: Users can delete a selected book from the system.
- **Search Books**: Users can search for books based on title, author, or ISBN.
- **Book List**: Displays a table of all added books.
- **Tabbed UI**: Contains separate tabs for book details and book list.
- **Toolbar & Menu Bar**: Quick access to functions like adding and removing books.

---

## Technologies Used 🌐
- **Java (JDK 8 or higher)**
- **Swing (javax.swing)** for GUI components
- **AWT (java.awt)** for event handling
- **Collections (ArrayList, HashMap)** for data storage

---

## How to Run 💬
1. Ensure **Java (JDK 8 or higher)** is installed on your system.
2. Copy the `LibraryManagementSystem.java` file into your Java project.
3. Compile the program using:
   ```sh
   javac LibraryManagementSystem.java
   ```
4. Run the program using:
   ```sh
   java LibraryManagementSystem
   ```

---

## User Guide 📁

### Adding a Book
1. Open the application.
2. Navigate to the **Book Details** tab.
3. Enter book details in the respective fields.
4. Click **"Add Book"**.
5. The book appears in the **Book List** tab.

### Updating a Book
1. Select a book from the **Book List** table.
2. Modify the details in the **Book Details** tab.
3. Click **"Update Book"**.

### Removing a Book
1. Select a book from the **Book List** table.
2. Click **"Remove Book"**.
3. Confirm deletion in the dialog box.

### Searching for a Book
1. Enter the search term in the search field.
2. Click **"Search"** to filter the book list.

---

## Known Issues & Limitations 👾
- The data is not persistent (books are lost when the application is closed).
- No database integration; currently uses in-memory storage.
- Only basic validation for input fields is performed.

## Future Improvements ⚙
- Implement database support (MySQL, SQLite, or MongoDB) for persistent storage.
- Add user authentication and role-based access.
- Enhance UI with better design and responsiveness.

---

## Author 💞
[Anushka Banerjee]
