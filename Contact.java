package contact;

public class Contact {
    private final String contactID;  // Unique contact ID 
    private String firstName;        
    private String lastName;         
    private String phone;            
    private String address;          

    // Constructor
    public Contact(String contactID, String firstName, String lastName, String phone, String address) {
        if (contactID != null && contactID.length() <= 10) {
            this.contactID = contactID;
        } else {
            System.out.println("Error, Contact ID can not be more than 10 characters or null.");
            this.contactID = "";
        }
        
        if (firstName != null && firstName.length() <= 10) {
            this.firstName = firstName;
        } else {
            System.out.println("Error, First Name can not be more than 10 characters or null.");
            this.firstName = "";
        }

        if (lastName != null && lastName.length() <= 10) {
            this.lastName = lastName;
        } else {
            System.out.println("Error, Last Name can not be more than 10 characters or null.");
            this.lastName = "";
        }

        if (phone != null && phone.length() == 10 && phone.matches("\\d+")) {
            this.phone = phone;
        } else {
            System.out.println("Error, Phone Number must be exactly 10 digits.");
            this.phone = "";
        }

        if (address != null && address.length() <= 30) {
            this.address = address;
        } else {
            System.out.println("Error, Address can not be more than 30 characters or null.");
            this.address = "";
        }
    }

    // Getters
    public String getContactID() {
        return contactID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    // Setters for fields that can be updated
    public void setFirstName(String firstName) {
        if (firstName != null && firstName.length() <= 10) {
            this.firstName = firstName;
        } else {
            System.out.println("Error, First Name can not be more than 10 characters or null.");
        }
    }

    public void setLastName(String lastName) {
        if (lastName != null && lastName.length() <= 10) {
            this.lastName = lastName;
        } else {
            System.out.println("Error, Last Name can not be more than 10 characters or null.");
        }
    }

    public void setPhone(String phone) {
        if (phone != null && phone.length() == 10 && phone.matches("only digits entered")) {
            this.phone = phone;
        } else {
            System.out.println("Error, Phone Number must be exactly 10 digits.");
        }
    }

    public void setAddress(String address) {
        if (address != null && address.length() <= 30) {
            this.address = address;
        } else {
            System.out.println("Error, First Name can not be more than 10 characters or null.");
        }
    }
}