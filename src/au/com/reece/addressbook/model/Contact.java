package au.com.reece.addressbook.model;

import java.io.Serializable;

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
}
