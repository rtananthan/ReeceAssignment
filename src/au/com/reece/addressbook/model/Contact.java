package au.com.reece.addressbook.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * Created by Ananthan on 20/8/17.
 */
public class Contact implements Serializable {

    private Integer contactId;

    private Integer addressBookId;

    private String firstName;

    private String lastName;

    private String phoneNo;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public Integer getContactId() {
        return contactId;
    }

    public void setContactId(Integer contactId) {
        this.contactId = contactId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(contactId, contact.contactId) &&
                Objects.equals(addressBookId, contact.addressBookId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contactId, addressBookId);
    }
}
