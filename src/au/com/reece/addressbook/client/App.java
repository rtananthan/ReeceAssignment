package au.com.reece.addressbook.client;

import au.com.reece.addressbook.model.AddressBook;
import au.com.reece.addressbook.model.BaseEntity;
import au.com.reece.addressbook.model.Contact;
import au.com.reece.addressbook.service.AddressBookService;
import au.com.reece.addressbook.service.AddressBookServiceImpl;
import au.com.reece.addressbook.service.ContactService;
import au.com.reece.addressbook.service.ContactServiceImpl;

import java.util.List;
import java.util.logging.Logger;

public class App {
    private final static Logger LOGGER = Logger.getLogger(App.class.getName());

    private AddressBookService addressBookService = new AddressBookServiceImpl();
    private ContactService contactService = new ContactServiceImpl();

    public static void main(String[] args) {
        App app = new App();
        app.startApp();

    }

    public void startApp(){
        testMultipleAddressBook();
        testCreateContact();
        testAddressBookNullNameTest();
    }

    private void testMultipleAddressBook(){
        try {
            AddressBook addressBook1 = new AddressBook();
            addressBook1.setAddressBookName("Book 1");
            addressBookService.saveAddressBook(addressBook1);

            AddressBook addressBook2 = new AddressBook();
            addressBook2.setAddressBookName("Book 2");
            addressBookService.saveAddressBook(addressBook2);

            AddressBook addressBook3 = new AddressBook();
            addressBook3.setAddressBookName("Book 3");
            addressBookService.saveAddressBook(addressBook3);

            if (addressBookService.findAllAddressBooks().size() == 3) {
                LOGGER.info("testMultipleAddressBook Passed");
            } else {
                LOGGER.info("testMultipleAddressBook failed");
            }
        }catch (Exception e){
            LOGGER.info("testMultipleAddressBook failed");

        }
    }

    private void testCreateContact(){
        List<BaseEntity> allBooks = addressBookService.findAllAddressBooks();
        AddressBook book1 = (AddressBook)allBooks.get(1);
        AddressBook book2 = (AddressBook)allBooks.get(2);

        Contact contact1 = new Contact();
        contact1.setAddressBook(book1);
        contact1.setFirstName("First Name 1");
        contact1.setLastName("Last Name 1");
        contact1.setPhoneNo("112345678");

        contactService.createContact(contact1);

        Contact contact2 = new Contact();
        contact2.setAddressBook(book1);
        contact2.setFirstName("First Name 2");
        contact2.setLastName("Last Name 2");
        contact2.setPhoneNo("212345678");
        contactService.createContact(contact2);

        Contact contact3 = new Contact();
        contact3.setAddressBook(book2);
        contact3.setFirstName("First Name 3");
        contact3.setLastName("Last Name 3");
        contact3.setPhoneNo("312345678");

        contactService.createContact(contact3);

        int size = contactService.findAll().size();

        if(size== 3){
            LOGGER.info("testCreateContact Passed");
        }
        else{
            LOGGER.info("testCreateContact failed");
        }

    }


    private void testAddressBookNullNameTest(){
        AddressBook addressBook4 = new AddressBook();
        addressBook4.setAddressBookName(null);
        try {
            addressBookService.saveAddressBook(addressBook4);
            LOGGER.info("testAddressBookNullNameTest Failed");
        } catch (Exception e) {
            LOGGER.info("testAddressBookNullNameTest Passed");
        }
    }

    private void testPrintUniqueContacts(){
       contactService.printUniqueContacts();
    }

    private void testAllContactsInAddressBook(){
      //contactService.printAllContacts();
    }

    private void testDeleteContact(){

    }


}
