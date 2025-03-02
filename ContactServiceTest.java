package contact;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {

    // Declare the ContactService object and some sample contacts
    private ContactService contactService;
    private Contact contact1;
    private Contact contact2;
    private Contact contactWithInvalidID;

    // This method runs before each test to set up the contacts and service
    @BeforeEach
    public void setUp() {
        // Initialize the ContactService (this is like creating a new contact book)
        contactService = new ContactService();
        
        // Create some sample contacts to test with
        contact1 = new Contact("C12345678", "Adam", "Sandler", "1234567890", "123 Main St");
        contact2 = new Contact("C23456789", "Zoe", "Kavitz", "0987654321", "456 Elm St");
        contactWithInvalidID = new Contact("", "Invalid", "Contact", "1234567890", "Invalid St");
    }

    // Test adding a valid contact
    @Test
    public void testAddContact() {
        // Add contact1 to the contact service
        contactService.addContact(contact1);
        
        // Retrieve the contact by ID and check if it was added
        Contact retrievedContact = contactService.getContact(contact1.getContactID());
        
        // Verify that the contact was successfully added
        assertNotNull(retrievedContact);  // Make sure the contact is not null
        assertEquals("Adam", retrievedContact.getFirstName());  // Check if the name matches
    }

    // Test adding a contact with an invalid ID (empty ID)
    @Test
    public void testAddContactWithInvalidID() {
        // Try adding a contact with an invalid ID (empty string)
        contactService.addContact(contactWithInvalidID);
        
        // Since the ID is invalid, it should not be added to the service
        Contact retrievedContact = contactService.getContact(contactWithInvalidID.getContactID());
        
        // The contact should be null because it wasn't added
        assertNull(retrievedContact);  
    }

    // Test adding a contact with a duplicate ID
    @Test
    public void testAddDuplicateContact() {
        // Add contact1 first
        contactService.addContact(contact1);
        
        // Try adding another contact with the same ID as contact1
        contactService.addContact(contact2); // contact2 has a different ID, check if duplicates are prevented
        
        // The contact with ID "C12345678" should be the same as contact1
        Contact retrievedContact = contactService.getContact(contact1.getContactID());
        
        // Verify that the original contact (contact1) was not replaced or duplicated
        assertEquals("Adam", retrievedContact.getFirstName());  // Check if it is still the original contact1
        assertNull(contactService.getContact(contact2.getContactID()));  // Ensure that contact2 wasn't added
    }

    // Test deleting an existing contact
    @Test
    public void testDeleteContact() {
        // Add contact1
        contactService.addContact(contact1);
        
        // Before deleting, make sure contact1 exists
        Contact retrievedContact = contactService.getContact(contact1.getContactID());
        assertNotNull(retrievedContact);  // Ensure contact1 exists
        
        // Now delete contact1
        contactService.deleteContact(contact1.getContactID());
        
        // After deletion, contact1 should no longer exist
        retrievedContact = contactService.getContact(contact1.getContactID());
        assertNull(retrievedContact);  // contact1 should be null after deletion
    }

    // Test deleting a contact that Sandlersn't exist
    @Test
    public void testDeleteNonExistentContact() {
        // Try to delete a contact that Sandlersn't exist (contact2 is not added yet)
        contactService.deleteContact(contact2.getContactID());
        
        // Ensure that contact2 is still not in the service
        assertNull(contactService.getContact(contact2.getContactID()));  // Should still be null
    }

    // Test updating a contact's details
    @Test
    public void testUpdateContact() {
        // Add contact1 to the service
        contactService.addContact(contact1);
        
        // Update the contact's details (change the first name and address)
        contactService.updateContact(contact1.getContactID(), "Mike", "Sandler", "1122334455", "789 Oak St");
        
        // Retrieve the updated contact
        Contact updatedContact = contactService.getContact(contact1.getContactID());
        
        // Check if the details have been updated
        assertEquals("Mike", updatedContact.getFirstName());  // First name should be updated to "Mike"
        assertEquals("789 Oak St", updatedContact.getAddress());  // Address should be updated
    }

    // Test updating a contact that Sandlersn't exist
    @Test
    public void testUpdateNonExistentContact() {
        // Try to update contact2 (which hasn't been added yet)
        contactService.updateContact(contact2.getContactID(), "Jake", "Kravitz", "6677889900", "101 Pine St");
        
        // Since contact2 Sandlersn't exist, it should not be updated
        assertNull(contactService.getContact(contact2.getContactID()));  // The contact should still be null
    }

    // Test retrieving a contact by ID
    @Test
    public void testGetContact() {
        // Add contact1 to the service
        contactService.addContact(contact1);
        
        // Retrieve contact1 by its ID
        Contact retrievedContact = contactService.getContact(contact1.getContactID());
        
        // Verify that the contact is retrieved correctly
        assertNotNull(retrievedContact);  // The contact should exist
        assertEquals("Adam", retrievedContact.getFirstName());  // The first name should be "Adam"
    }

    // Test getting a contact that Sandlersn't exist
    @Test
    public void testGetNonExistentContact() {
        // Try to get contact2, which doesn't exist
        Contact retrievedContact = contactService.getContact(contact2.getContactID());
        
        // Since contact2 doesn't exist, it should return null
        assertNull(retrievedContact);
    }
}
