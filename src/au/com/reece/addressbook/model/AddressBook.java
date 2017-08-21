package au.com.reece.addressbook.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * Created by Ananthan on 20/8/17.
 */
public class AddressBook  extends BaseEntity {

    private String addressBookName;

    public String getAddressBookName() {
        return addressBookName;
    }

    public void setAddressBookName(String addressBookName) {
        this.addressBookName = addressBookName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof AddressBook))
            return false;
        AddressBook that = (AddressBook) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

}
