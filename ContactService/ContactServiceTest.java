
import com.warnercloud.Model.Contact;
import com.warnercloud.Service.ContactService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactServiceTest {

    private ContactService service;
    private Contact contact;

    @BeforeEach
    void setUp() {
        service = new ContactService();
        contact = new Contact("1234", "John", "Doe", "1234567890", "123 Main Street");
    }

    @Test
    void testAddContact() {
        service.addContact(contact);
        service.updateFirstName("1234", "Jane");
        assertEquals("Jane", contact.getFirstName());
    }

    @Test
    void testAddDuplicateContact() {
        service.addContact(contact);
        assertThrows(IllegalArgumentException.class, () -> service.addContact(contact));
    }

    @Test
    void testDeleteContact() {
        service.addContact(contact);
        service.deleteContact(contact.getContactID());
        assertThrows(IllegalArgumentException.class, () -> service.updateFirstName("1234", "NewName"));
    }

    @Test
    void testUpdateFirstName() {
        service.addContact(contact);
        service.updateFirstName("1234", "Barry");
        assertEquals("Barry", contact.getFirstName());
    }

    @Test
    void testUpdateLastName() {
        service.addContact(contact);
        service.updateLastName("1234", "Allen");
        assertEquals("Allen", contact.getLastName());
    }

    @Test
    void testUpdatePhone() {
        service.addContact(contact);
        service.updateNumber("1234", "1234123412");
        assertEquals("1234123412", contact.getPhone());
    }

    @Test
    void testUpdateAddress() {
        service.addContact(contact);
        service.updateAddress("1234", "124 Elm Street");
        assertEquals("124 Elm Street", contact.getAddress());
    }

    @Test
    void testUpdateNonExistingContact() {
        assertThrows(IllegalArgumentException.class, () -> service.updateFirstName("999", "Mark"));
    }
}

