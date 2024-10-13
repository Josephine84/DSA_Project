
import java.util.Scanner;

public class AddContact {
    public static void main(String[] args) {
        Phonebook phonebook = new Phonebook();
        Scanner scanner = new Scanner(System.in);
        
        addContact(phonebook, scanner);
        
        // Display the added contact
        System.out.println("\nContact added to phonebook:");
        phonebook.displayAllContacts();
        
        scanner.close();
    }

    public static void addContact(Phonebook phonebook, Scanner scanner) {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();
        phonebook.addContact(new Contact(name, phoneNumber));
        System.out.println("Contact added successfully.");
    }
}