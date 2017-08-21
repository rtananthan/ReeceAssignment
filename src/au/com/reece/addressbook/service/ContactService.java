
package au.com.reece.addressbook.service;

import au.com.reece.addressbook.model.AddressBook;
import au.com.reece.addressbook.model.BaseEntity;
import au.com.reece.addressbook.model.Contact;

import java.util.List;

public interface ContactService {

    public Boolean createContact(Contact contact);

    public Boolean deleteContact(Contact contact);

//    public void assignToAddressBook(Contact contact, AddressBook addressBook);

    public void printAllContacts(AddressBook addressBook);

    public void printUniqueContacts();

    public BaseEntity findById(Integer id);

    public List<BaseEntity> findAll();
}
