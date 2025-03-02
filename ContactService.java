package contact;

import java.util.HashMap;
import java.util.Map;

public class ContactService {
    private Map<String, Contact> contacts = new HashMap<>();

    // Add a contact
    public void addContact(Contact contact) {
        if (contact.getContactID().isEmpty()) {
            System.out.println("Can not add contact with invalid ID.");
            return;
        }
        if (contacts.containsKey(contact.getContactID())) {
            System.out.println("Contact with this ID already exists.");
        } else {
            contacts.put(contact.getContactID(), contact);
            System.out.println("Contact added successfully.");
        }
    }

    // Delete a contact by ID
    public void deleteContact(String contactID) {
        if (contacts.containsKey(contactID)) {
            contacts.remove(contactID);
            System.out.println("Contact deleted.");
        } else {
            System.out.println("Contact with this ID does not exist.");
        }
    }

    // Update a contact's information
    public void updateContact(String contactID, String firstName, String lastName, String phone, String address) {
        Contact contact = contacts.get(contactID);
        if (contact != null) {
            if (firstName != null) contact.setFirstName(firstName);
            if (lastName != null) contact.setLastName(lastName);
            if (phone != null) contact.setPhone(phone);
            if (address != null) contact.setAddress(address);
            System.out.println("Contact updated successfully.");
        } else {
            System.out.println("Contact with this ID does not exist.");
        }
    }

    // Get a contact by ID
    public Contact getContact(String contactID) {
        return contacts.get(contactID);
    }
}
