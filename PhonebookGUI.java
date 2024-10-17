import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class PhonebookGUI extends JFrame {
    private Phonebook phonebook;
    private JTextField nameField, phoneField, searchField;
    private JTextArea displayArea;
    private JButton addButton, searchButton, displayAllButton, deleteButton, updateButton, sortButton, saveButton;

    public PhonebookGUI() {
        phonebook = new Phonebook();
        phonebook.loadFromFile("contacts.txt");

        setTitle("Phonebook Application");
        setSize(550, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create panels
        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JPanel displayPanel = new JPanel(new BorderLayout());

        // Create components
        nameField = new JTextField(20);
        phoneField = new JTextField(20);
        searchField = new JTextField(20);
        displayArea = new JTextArea(15, 40);
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);

        addButton = createMediumSmallButton("Add");
        searchButton = createMediumSmallButton("Search");
        displayAllButton = createMediumSmallButton("Display All");
        deleteButton = createMediumSmallButton("Delete");
        updateButton = createMediumSmallButton("Update");
        sortButton = createMediumSmallButton("Sort");
        saveButton = createMediumSmallButton("Save");

        // Add components to panels
        inputPanel.add(new JLabel("Name:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Phone:"));
        inputPanel.add(phoneField);
        inputPanel.add(new JLabel("Search:"));
        inputPanel.add(searchField);

        buttonPanel.add(addButton);
        buttonPanel.add(searchButton);
        buttonPanel.add(displayAllButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(sortButton);
        buttonPanel.add(saveButton);

        displayPanel.add(scrollPane, BorderLayout.CENTER);

        // Add panels to frame
        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(displayPanel, BorderLayout.SOUTH);

        // Add action listeners
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addContact();
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchContact();
            }
        });

        displayAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayAllContacts();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteContact();
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateContact();
            }
        });

        sortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sortContacts();
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveContactsToFile();
            }
        });
    }
    
    private void addContact() {
        String name = nameField.getText();
        String phone = phoneField.getText();
        if (!name.isEmpty() && !phone.isEmpty()) {
            phonebook.addContact(new Contact(name, phone));
            displayArea.setText("Contact added successfully.");
            nameField.setText("");
            phoneField.setText("");
        } else {
            displayArea.setText("Please enter both name and phone number.");
        }
    }

    private void searchContact() {
        String name = searchField.getText();
        if (!name.isEmpty()) {
            Contact contact = phonebook.searchContact(name);
            if (contact != null) {
                displayArea.setText("Contact found: " + contact);
            } else {
                displayArea.setText("Contact not found.");
            }
        } else {
            displayArea.setText("Please enter a name to search.");
        }
    }

    private void displayAllContacts() {
        StringBuilder sb = new StringBuilder();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        PrintStream old = System.out;
        System.setOut(ps);

        phonebook.displayAllContacts();

        System.out.flush();
        System.setOut(old);
        
        String result = baos.toString();
        displayArea.setText(result);
    }

    private void deleteContact() {
        String name = searchField.getText();
        if (!name.isEmpty()) {
            if (phonebook.deleteContact(name)) {
                displayArea.setText("Contact deleted successfully.");
            } else {
                displayArea.setText("Contact not found.");
            }
        } else {
            displayArea.setText("Please enter a name to delete.");
        }
    }

    private void updateContact() {
        String name = nameField.getText();
        String newPhone = phoneField.getText();
        if (!name.isEmpty() && !newPhone.isEmpty()) {
            if (phonebook.updateContact(name, newPhone)) {
                displayArea.setText("Contact updated successfully.");
            } else {
                displayArea.setText("Contact not found.");
            }
        } else {
            displayArea.setText("Please enter both name and new phone number.");
        }
    }

    private void sortContacts() {
        phonebook.sortContacts();
        displayArea.setText("Contacts sorted.");
    }

    private void saveContactsToFile() {
        phonebook.saveToFile("contacts.txt");
        displayArea.setText("Contacts saved to file.");
    }

    private JButton createMediumSmallButton(String text) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(100, 30));
        return button;
    }

    // The rest of the methods (addContact, searchContact, etc.) remain the same

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PhonebookGUI().setVisible(true);
            }
        });
    }
}