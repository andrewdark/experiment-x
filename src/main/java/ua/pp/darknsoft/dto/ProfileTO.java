package ua.pp.darknsoft.dto;

public class ProfileTO {
    private String firstName;
    private String lastName;
    private String email;

    public String getFirstName() {
        return firstName;
    }
    public ProfileTO setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }
    public ProfileTO setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }
    public ProfileTO setEmail(String email) {
        this.email = email;
        return this;
    }
}
