package au.com.reece.addressbook.model;

import java.io.Serializable;

/**
 * Created by Ananthan on 20/8/17.
 */
public class AddressBook  implements Serializable{

    private Integer addressBookId;

    private String addressBookName;

    public Integer getAddressBookId() {
        return addressBookId;
    }

    public void setAddressBookId(Integer addressBookId) {
        this.addressBookId = addressBookId;
    }
}
