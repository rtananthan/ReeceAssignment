package au.com.reece.addressbook.service;

import au.com.reece.addressbook.au.com.reece.addressbook.dao.AddressBookDAOImpl;
import au.com.reece.addressbook.au.com.reece.addressbook.dao.ContactDAOImpl;
import au.com.reece.addressbook.model.AddressBook;
import au.com.reece.addressbook.model.BaseEntity;
import au.com.reece.addressbook.model.Contact;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class ContactServiceImpl implements ContactService {

    private final static Logger LOGGER = Logger.getLogger(ContactServiceImpl.class.getName());

    private ContactDAOImpl contactDAO;

    private AddressBookDAOImpl addressBookDAO;

    public ContactServiceImpl(){
        contactDAO = new ContactDAOImpl();
        addressBookDAO = new AddressBookDAOImpl();
    }

    /**
     * @param contact
     */
    @Override
    public Boolean createContact(Contact contact) {
       if(contact == null){
           LOGGER.info("Can not create a null contact");
           return false;
       }
       return contactDAO.save(contact);
    }

    /**
     * Deletes a given contact
     * @param contact
     */
    @Override
    public Boolean deleteContact(Contact contact) {
        if(contact == null || contact.getId() == null || contactDAO.get(contact.getId()) == null){
            LOGGER.info("Can not create a null contact or a non existing contact");
            return false;
        }
      return contactDAO.delete(contact);
    }


    /**
     * Prints all contacts in a given address book
     * @param addressBook AddressBook that needs to be printed
     */
    @Override
    public void printAllContacts(AddressBook addressBook) {
        List<BaseEntity> list = contactDAO.findAll().collect(Collectors.toList());
        if(list == null || list.size() > 0){
            LOGGER.info("There are no contacts existing");
            return;
        }
        if(!addressBookDAO.get(addressBook.getId()).isPresent()){
            LOGGER.info("Address book doesnt exist");
        }
        for (BaseEntity entity : list) {
            Contact contact = (Contact)entity;
            if(addressBook.getId().equals(contact.getId())){
                LOGGER.info(contact.getFirstName()+","+contact.getLastName());
            }
        }
    }

    /**
     * Prints all unique contacts across Address Books
     */
    @Override
    public void printUniqueContacts() {
        List<BaseEntity> list = contactDAO.findAll().collect(Collectors.toList());
        if(list == null || list.size() == 0){
            LOGGER.info("There are no contacts existing");
            return;
        }
        Set<String> contactNameSet = new HashSet<>();
        StringBuilder stringBuilder ;
        for (BaseEntity baseEntity: list) {
            Contact contact = (Contact) baseEntity;
            stringBuilder = new StringBuilder();
            stringBuilder.append(contact.getFirstName());
            stringBuilder.append(" ");
            stringBuilder.append(contact.getLastName());
            contactNameSet.add(stringBuilder.toString());
        }

        contactNameSet.stream().forEach(s -> LOGGER.info(s+"\n"));
    }

    @Override
    public BaseEntity findById(Integer id) {
        Optional<BaseEntity> contact = contactDAO.get(id);
        if(contact.isPresent()){
            return (Contact) contact.get();
        }
        return null;
    }

    @Override
    public List<BaseEntity> findAll() {
        return contactDAO.findAll().collect(Collectors.toList());
    }
}
