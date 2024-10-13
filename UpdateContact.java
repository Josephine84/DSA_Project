import java.util.Scanner;

public class UpdateContact {
    public static void main(String[] args) {
        Phonebook phonebook = new Phonebook();
        Scanner scanner = new Scanner(System.in);
        
        // Add a contact for demonstration
        phonebook.addContact(new Contact("Josephine Kufuna", "0857763683"));
        phonebook.addContact(new Contact("Senia Shipepe", "0814616425"));
        
        updateContact(phonebook, scanner);
        
        // Display updated contact
        System.out.println("\nUpdated contact:");
        phonebook.displayAllContacts();
        
        scanner.close();
    }

    public static void updateContact(Phonebook phonebook, Scanner scanner) {
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
}
