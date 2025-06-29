import com.warnercloud.Model.Contact;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ContactTest {
    @Test
    void testContactCreation() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main Street");
        assertEquals("1234567890", contact.getContactID());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main Street", contact.getAddress());
    }

    @Test
    void testContactID() {
        //Contact ID too Long > 10
        assertThrows(IllegalArgumentException.class, () ->{
                new Contact("12345678901", "John", "Doe", "1234567890", "123 Main Street");
        });
        //Contact ID null
        assertThrows(IllegalArgumentException.class, () ->{
                new Contact(null, "John", "Doe", "1234567890", "123 Main Street");
        });
    }


    @Test
    void testFirstName() {
        //First Name Too long > 10
        assertThrows(IllegalArgumentException.class, () ->{
            new Contact("1234567890", "Very Long First Name", "Doe", "1234567890", "123 Main Street");
        });
        //First Name null
        assertThrows(IllegalArgumentException.class, () ->{
            new Contact("1234567890", null, "Doe", "1234567890", "123 Main Street");
        });
    }

    @Test
    void testLastName() {
        //Last Name Too long > 10
        assertThrows(IllegalArgumentException.class, () ->{
            new Contact("1234567890", "John", "Very Long First Name", "1234567890", "123 Main Street");
        });
        //Last Name null
        assertThrows(IllegalArgumentException.class, () ->{
            new Contact("12345678901", "John", null, "1234567890", "123 Main Street");
        });
    }

    @Test
    void testPhone(){
        //Number to Long > 10
        assertThrows(IllegalArgumentException.class, () ->{
            new Contact("1234567890", "John", "Doe", "12345678901", "123 Main Street");
        });

        //Number to Short < 10
        assertThrows(IllegalArgumentException.class, () ->{
            new Contact("1234567890", "John", "Doe", "123456789", "123 Main Street");
        });

        //Number contains non digits
        assertThrows(IllegalArgumentException.class, () ->{
            new Contact("1234567890", "John", "Doe", "1234ert34", "123 Main Street");
        });
        //Number is null
        assertThrows(IllegalArgumentException.class, () ->{
            new Contact("1234567890", "John", "Doe", null, "123 Main Street");
        });
    }

    @Test
    void testAddress() {
        //Address to Long > 30
        assertThrows(IllegalArgumentException.class, () ->{
            new Contact("1234567890", "John", "Doe", "1234567890", "123 Main Street South Northern Southern New Hampshire NH, NY, PA, 200948358");
        });
        //Address is null
        assertThrows(IllegalArgumentException.class, () ->{
            new Contact("1234567890", "John", "Doe", "1234567890", null);
        });
    }
}
