package au.com.reece.addressbook.service;

import au.com.reece.addressbook.au.com.reece.addressbook.dao.AddressBookDAOImpl;
import au.com.reece.addressbook.model.AddressBook;
import au.com.reece.addressbook.model.BaseEntity;

import java.util.List;
import java.util.stream.Collectors;

public class AddressBookServiceImpl implements AddressBookService {
    private AddressBookDAOImpl addressBookDAO;

    public AddressBookServiceImpl(){
        addressBookDAO = new AddressBookDAOImpl();
    }

    @Override
    public void saveAddressBook(AddressBook addressBook) throws Exception {
        if(addressBook.getAddressBookName() == null || addressBook.getAddressBookName().length() == 0){
            throw new Exception("Address Book Name cant be null");
        }
        addressBookDAO.save(addressBook);

    }

    @Override
    public void deleteAddressBook(AddressBook addressBook) {

        addressBookDAO.delete(addressBook);
    }

    @Override
    public List<BaseEntity> findAllAddressBooks() {
        return addressBookDAO.findAll().collect(Collectors.toList());
    }


}
