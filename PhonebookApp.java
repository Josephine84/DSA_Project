import java.util.Scanner;

public class PhonebookApp {
    private static Scanner scanner = new Scanner(System.in);
    private static Phonebook phonebook = new Phonebook();

    public static void main(String[] args) {
        phonebook.loadFromFile("contacts.txt");
        while (true) {
            System.out.println("\nPhonebook Application");
            System.out.println("1. Add Contact");
            System.out.println("2. Search Contact");
            System.out.println("3. Display All Contacts");
            System.out.println("4. Delete Contact");
            System.out.println("5. Update Contact");
            System.out.println("6. Sort Contacts");
            System.out.println("7. Save Contacts to File");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            
            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1: addContact(); break;
                case 2: searchContact(); break;
                case 3: displayAllContacts(); break;
                case 4: deleteContact(); break;
                case 5: updateContact(); break;
                case 6: sortContacts(); break;
                case 7: saveContactsToFile(); break;
                case 8:
                    System.out.println("Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addContact() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();
        phonebook.addContact(new Contact(name, phoneNumber));
        System.out.println("Contact added successfully.");
    }

    private static void searchContact() {
        System.out.print("Enter name to search: ");
        String name = scanner.nextLine();
        Contact contact = phonebook.searchContact(name);
        if (contact != null) {
            System.out.println("Contact found: " + contact);
        } else {
            System.out.println("Contact not found.");
        }
    }

    private static void displayAllContacts() {
        System.out.println("All Contacts:");
        phonebook.displayAllContacts();
    }

    private static void deleteContact() {
        System.out.print("Enter name to delete: ");
        String name = scanner.nextLine();
        if (phonebook.deleteContact(name)) {
            System.out.println("Contact deleted successfully.");
        } else {
            System.out.println("Contact not found.");
        }
    }

    private static void updateContact() {
        System.out.print("Enter name to update: ");
        String name = scanner.nextLine();
        System.out.print("Enter new phone number: ");
        String newPhoneNumber = scanner.nextLine();
        if (phonebook.updateContact(name, newPhoneNumber)) {
            System.out.println("Contact updated successfully.");
        } else {
            System.out.println("Contact not found.");
        }
    }

    private static void sortContacts() {
        phonebook.sortContacts();
        System.out.println("Contacts sorted.");
    }

    private static void saveContactsToFile() {
        phonebook.saveToFile("contacts.txt");
        System.out.println("Contacts saved to file.");
    }
}
