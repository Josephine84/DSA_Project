import java.util.Scanner;

public class DeleteContact {
    public static void main(String[] args) {
        Phonebook phonebook = new Phonebook();
        Scanner scanner = new Scanner(System.in);
        
        // Add some contacts for demonstration
        phonebook.addContact(new Contact("Josephine Kufuna", "0857763683"));
        phonebook.addContact(new Contact("Senia Shipepe", "0814616425"));
        
        deleteContact(phonebook, scanner);
        
        // Display remaining contacts
        System.out.println("\nRemaining contacts:");
        phonebook.displayAllContacts();
        
        scanner.close();
    }

    public static void deleteContact(Phonebook phonebook, Scanner scanner) {
        System.out.print("Enter name to delete: ");
        String name = scanner.nextLine();
        if (phonebook.deleteContact(name)) {
            System.out.println("Contact deleted successfully.");
        } else {
            System.out.println("Contact not found.");
        }
    }
}

