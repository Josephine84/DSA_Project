public class SortContacts {
    public static void main(String[] args) {
        Phonebook phonebook = new Phonebook();
        
        // Add some contacts for demonstration
        phonebook.addContact(new Contact("Josephine Kufuna", "0857763683"));
        phonebook.addContact(new Contact("Senia Shipepe", "0814616425"));
        phonebook.addContact(new Contact("Alice Johnson", "5555555555"));
        
        System.out.println("Before sorting:");
        phonebook.displayAllContacts();
        
        sortContacts(phonebook);
        
        System.out.println("\nAfter sorting:");
        phonebook.displayAllContacts();
    }

    public static void sortContacts(Phonebook phonebook) {
        phonebook.sortContacts();
        System.out.println("Contacts sorted.");
    }
}

