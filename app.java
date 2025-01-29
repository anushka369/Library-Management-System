import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;

public class LibraryManagementSystem
{
    private JFrame frame;
    private JTextField titleField, authorField, isbnField, yearField, searchField;
    private JComboBox<String> genreComboBox;
    private JCheckBox availabilityCheckBox;
    private JTable bookTable;

    private DefaultTableModel tableModel;
    private ArrayList <HashMap <String, String>> books;

    public LibraryManagementSystem()
    {
        books = new ArrayList<>();
        initialize();
    }

    private void initialize()
    {
        // Main Frame
        frame = new JFrame("Library Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());

        // Menu Bar
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");
        JMenu helpMenu = new JMenu("Help");

        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);
        frame.setJMenuBar(menuBar);

        // ToolBar
        JToolBar toolBar = new JToolBar();
        JButton addButton = new JButton("Add Book");
        JButton removeButton = new JButton("Remove Book");
        JButton searchButton = new JButton("Search");

        toolBar.add(addButton);
        toolBar.add(removeButton);
        toolBar.add(searchButton);
        frame.add(toolBar, BorderLayout.NORTH);

        // TabbedPane
        JTabbedPane tabbedPane = new JTabbedPane();

        // Book Details Panel
        JPanel bookDetailsPanel = new JPanel();
        bookDetailsPanel.setLayout(new GridLayout(6, 2));

        bookDetailsPanel.add(new JLabel("Title:"));
        titleField = new JTextField();
        bookDetailsPanel.add(titleField);

        bookDetailsPanel.add(new JLabel("Author:"));
        authorField = new JTextField();
        bookDetailsPanel.add(authorField);

        bookDetailsPanel.add(new JLabel("ISBN:"));
        isbnField = new JTextField();
        bookDetailsPanel.add(isbnField);

        bookDetailsPanel.add(new JLabel("Publication Year:"));
        yearField = new JTextField();
        bookDetailsPanel.add(yearField);

        bookDetailsPanel.add(new JLabel("Genre:"));
        genreComboBox = new JComboBox<>(new String[]
        {"Fiction", "Non-Fiction", "Science", "Biography", "History"});
        
        bookDetailsPanel.add(genreComboBox);
        bookDetailsPanel.add(new JLabel("Available:"));

        availabilityCheckBox = new JCheckBox();
        bookDetailsPanel.add(availabilityCheckBox);

        JButton addBookButton = new JButton("Add Book");
        bookDetailsPanel.add(addBookButton);

        JButton updateBookButton = new JButton("Update Book");
        bookDetailsPanel.add(updateBookButton);
        tabbedPane.addTab("Book Details", bookDetailsPanel);

        // Book List Panel
        JPanel bookListPanel = new JPanel(new BorderLayout());
        searchField = new JTextField(20);
        JButton searchBookButton = new JButton("Search");
        JPanel searchPanel = new JPanel();

        searchPanel.add(searchField);
        searchPanel.add(searchBookButton);

        String[] columnNames = {"Title", "Author", "ISBN", "Genre", "Availability"};
        tableModel = new DefaultTableModel(columnNames, 0);

        bookTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(bookTable);

        bookListPanel.add(searchPanel, BorderLayout.NORTH);
        bookListPanel.add(scrollPane, BorderLayout.CENTER);

        tabbedPane.addTab("Book List", bookListPanel);
        frame.add(tabbedPane, BorderLayout.CENTER);

        // Event Handling
        addBookButton.addActionListener(e -> addBook());
        updateBookButton.addActionListener(e -> updateBook());
        searchBookButton.addActionListener(e -> searchBook());
        removeButton.addActionListener(e -> removeBook());
        searchButton.addActionListener(e -> searchBook());
        frame.setVisible(true);
    }

    // Function to Add Book
    private void addBook()
    {
        HashMap <String, String> book = new HashMap<>();
        book.put("Title", titleField.getText());
        book.put("Author", authorField.getText());
        book.put("ISBN", isbnField.getText());
        book.put("Year", yearField.getText());
        book.put("Genre", (String) genreComboBox.getSelectedItem());

        if (availabilityCheckBox.isSelected())
        {
            book.put("Availability", "Available");
        }

        else
        {
            book.put("Availability", "Not Available");
        }

        books.add(book);
        updateTable();
        clearFields();
    }

    // Function to Update Book Table
    private void updateTable()
    {
        tableModel.setRowCount(0); // Clear Table
        for (HashMap<String, String> book : books)
        {
            tableModel.addRow(new Object[]
            {
                book.get("Title"),
                book.get("Author"),
                book.get("ISBN"),
                book.get("Genre"),
                book.get("Availability")
            });
        }
    }

    // Function to Clear Input Fields
    private void clearFields()
    {
        titleField.setText("");
        authorField.setText("");
        isbnField.setText("");
        yearField.setText("");

        genreComboBox.setSelectedIndex(0);
        availabilityCheckBox.setSelected(false);
    }

    // Function to Remove Book
    private void removeBook()
    {
        int selectedRow = bookTable.getSelectedRow();
        if (selectedRow != -1)
        {
            int dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure to delete the selected book?", "Confirmation", JOptionPane.YES_NO_OPTION);
            if (dialogResult == JOptionPane.YES_OPTION)
            {
                books.remove(selectedRow);
                updateTable();
            }
        }

        else
        {
            JOptionPane.showMessageDialog(frame, "No book selected!", "Error",
            JOptionPane.ERROR_MESSAGE);
        }
    }

    // Function to Search Book
    private void searchBook()
    {
        String searchText = searchField.getText().toLowerCase();
        tableModel.setRowCount(0);

        for (HashMap<String, String> book : books)
        {        
            if (book.get("Title").toLowerCase().contains(searchText) ||
            book.get("Author").toLowerCase().contains(searchText) ||
            book.get("ISBN").toLowerCase().contains(searchText))
            {
                tableModel.addRow(new Object[]
                {
                    book.get("Title"),
                    book.get("Author"),
                    book.get("ISBN"),
                    book.get("Genre"),
                    book.get("Availability")
                });
            }
        }
    }

    // Function to Update Book (Additional Implementation)
    private void updateBook()
    {
        int selectedRow = bookTable.getSelectedRow();
        if (selectedRow != -1)
        {
            HashMap<String, String> book = books.get(selectedRow);
            book.put("Title", titleField.getText());
            book.put("Author", authorField.getText());
            book.put("ISBN", isbnField.getText());
            book.put("Year", yearField.getText());
            book.put("Genre", (String) genreComboBox.getSelectedItem());

            if (availabilityCheckBox.isSelected())
            {
                book.put("Availability", "Available");
            }

            else
            {
                book.put("Availability", "Not Available");
            }
            updateTable();
        }
        
        else        
        {
            JOptionPane.showMessageDialog(frame, "No book selected to update!",
            "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
        
    public static void main(String[] args)
    {
        new LibraryManagementSystem();
    }
}
