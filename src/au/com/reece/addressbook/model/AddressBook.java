package au.com.reece.addressbook.model;

import java.io.Serializable;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressBook that = (AddressBook) o;
        return Objects.equals(addressBookId, that.addressBookId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(addressBookId);
    }
}
