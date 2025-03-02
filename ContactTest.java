package contact;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

    private Contact validContact;
    private Contact invalidContact;
    private Contact contactWithInvalidPhone;

    // This method runs before each test to set up the contact objects
    @BeforeEach
    public void setUp() {
        // Valid contact
        validContact = new Contact("C12345678", "Adam", "Sandler", "1234567890", "123 Main St");

        // Invalid contact with an ID longer than 10 characters
        invalidContact = new Contact("C12345678901", "Adam", "Sandler", "1234567890", "123 Main St");

        // Contact with an empty phone number
        contactWithInvalidPhone = new Contact("C12345678", "Zoe", "Sandler", "", "123 Main St");
    }

    // Test for valid contact creation
    @Test
    public void testValidContact() {
        assertEquals("C12345678", validContact.getContactID());   // Test valid contact ID
        assertEquals("Adam", validContact.getFirstName());         // Test valid first name
        assertEquals("Sandler", validContact.getLastName());           // Test valid last name
        assertEquals("1234567890", validContact.getPhone());       // Test valid phone number
        assertEquals("123 Main St", validContact.getAddress());    // Test valid address
    }

    // Test for invalid contact creation (ID longer than 10 characters)
    @Test
    public void testInvalidContactID() {
        assertEquals("", invalidContact.getContactID());  // Should be empty because the ID is invalid
    }

    // Test for invalid phone number (empty string in constructor)
    @Test
    public void testInvalidPhone() {
        assertEquals("", contactWithInvalidPhone.getPhone());  // Should be empty because the phone is invalid
    }

    // Test for setter method to change the first name
    @Test
    public void testSetFirstName() {
        validContact.setFirstName("Mike");  // Set new first name
        assertEquals("Mike", validContact.getFirstName());  // Check if the first name changed correctly
    }

    // Test for invalid first name (more than 10 characters)
    @Test
    public void testSetInvalidFirstName() {
        validContact.setFirstName("Alexander");
        assertEquals("Adam", validContact.getFirstName());  // Should not change because the name is too long
    }

    // Test for setter method to change the phone number
    @Test
    public void testSetPhone() {
        validContact.setPhone("9876543210");  // Set new phone number
        assertEquals("9876543210", validContact.getPhone());  // Check if the phone number changed correctly
    }

    // Test for invalid phone number (not 10 digits)
    @Test
    public void testSetInvalidPhone() {
        validContact.setPhone("12345");
        assertEquals("1234567890", validContact.getPhone());  // Should not change because the phone number is invalid
    }

    // Test for setter method to change the address
    @Test
    public void testSetAddress() {
        validContact.setAddress("456 Elm St");
        assertEquals("456 Elm St", validContact.getAddress());  // Check if the address changed correctly
    }

    // Test for invalid address (more than 30 characters)
    @Test
    public void testSetInvalidAddress() {
        validContact.setAddress("456 Elm Street, Some City, Some Country");
        assertEquals("123 Main St", validContact.getAddress());  // Should not change because the address is too long
    }
}
