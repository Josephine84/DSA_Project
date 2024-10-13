public class SaveContactsToFile {
    public static void main(String[] args) {
        Phonebook phonebook = new Phonebook();
        
        // Add some contacts for demonstration
        phonebook.addContact(new Contact("Josephine Kufuna", "0857763683"));
        phonebook.addContact(new Contact("Senia Shipepe", "0814616425"));
        
        saveContactsToFile(phonebook);
    }

    public static void saveContactsToFile(Phonebook phonebook) {
        String filename = "contacts.txt";
        phonebook.saveToFile(filename);
        System.out.println("Contacts saved to " + filename);
    }
}
