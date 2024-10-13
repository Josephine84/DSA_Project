import java.util.Scanner;

public class SearchContact {
    public static void main(String[] args) {
        Phonebook phonebook = new Phonebook();
        Scanner scanner = new Scanner(System.in);
        
        // Add some contacts for demonstration
        phonebook.addContact(new Contact("Josephine Kufuna", "0857763683"));
        phonebook.addContact(new Contact("Senia Shipepe", "0814616425"));
        
        searchContact(phonebook, scanner);
        
        scanner.close();
    }

    public static void searchContact(Phonebook phonebook, Scanner scanner) {
        System.out.print("Enter name to search: ");
        String name = scanner.nextLine();
        Contact contact = phonebook.searchContact(name);
        if (contact != null) {
            System.out.println("Contact found: " + contact);
        } else {
            System.out.println("Contact not found.");
        }
    }
}


