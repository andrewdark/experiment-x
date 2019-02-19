package ua.pp.darknsoft.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity(name = "Profile")
@Table(name = "profiles")
public class Profile {
    @Version
    private Long version;

    @Id
    private Long id;

    @Column(name = "first_name", updatable = true)
    private String firstName;

    @Column(name = "last_name", updatable = true)
    private String lastName;

    //not all valid emails passed
    @Column(updatable = true)
    //@Pattern(regexp = "^[-\\w.]+@([A-z0-9][-A-z0-9]+\\.)+[A-z]{2,4}$")
    private String email;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @NotNull
    private User user;

    public Profile() {}

    public Long getVersion() {
        return version;
    }
    public void setVersion(Long version) {
        this.version = version;
    }

    public Long getId() {
        return id;
    }
    public Profile setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }
    public Profile setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }
    public Profile setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }
    public Profile setEmail(String email) {
        this.email = email;
        return this;
    }

    public User getUser() {
        return user;
    }
    public Profile setUser(User user) {
        this.user = user;
        return this;
    }
}
