package au.com.reece.addressbook.service;

import au.com.reece.addressbook.model.AddressBook;
import au.com.reece.addressbook.model.BaseEntity;

import java.util.List;

public interface AddressBookService {

    public void saveAddressBook(AddressBook addressBook) throws Exception;

    public void deleteAddressBook(AddressBook addressBook);

    public List<BaseEntity> findAllAddressBooks();

}
