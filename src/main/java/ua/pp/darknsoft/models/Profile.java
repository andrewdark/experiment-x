package ua.pp.darknsoft.models;

import javax.persistence.Embeddable;
import javax.validation.constraints.Pattern;

@Embeddable
public class Profile {
    private String firstName;
    private String lastName;
    @Pattern(regexp = "^[-\\w.]+@([A-z0-9][-A-z0-9]+\\.)+[A-z]{2,4}$")
    private String email;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
