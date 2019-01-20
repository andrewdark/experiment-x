package ua.pp.darknsoft.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static java.util.Objects.requireNonNull;

@Entity
@Table(name = "APP_USER", uniqueConstraints = {@UniqueConstraint(name = "APP_USER_UC", columnNames = "user_name")})
public class User implements UserDetails {
    private static final long serialVersionUID = 1L;

    @JsonCreator
    public User(@JsonProperty("username") final String username,
                @JsonProperty("password") final String encryptedPassword) {
        super();
        this.username = requireNonNull(username);
        this.encryptedPassword = requireNonNull(encryptedPassword);
    }

    public User(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "user_name", length = 36, nullable = false)
    //@Pattern(regexp = "^[a-zA-Z][a-zA-Z0-9-_\\.]{2,36}$")
    private String username;
    @Column(name = "encrypted_password", length = 128, nullable = false)
    //@Pattern(regexp = "((?=.*[a-z])(?=.*d)(?=.*[@#$&])(?=.*[A-Z]).{8,32})")//
    //@Pattern(regexp = "(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$")
    private String encryptedPassword;
    @Column(name = "enabled", nullable = false)
    private Boolean enabled = true;
    @NotNull
    private LocalDateTime created = LocalDateTime.now();
    @Column(name = "last_login")
    private LocalDateTime lastLogin;
    @Version
    private Long version;
    @OneToMany(mappedBy = "appUser")
    private Set<RoledUser> roledUsers = new HashSet<>();
    @OneToMany(mappedBy = "appUser")
    private  Set<UserTasks> userTasks = new HashSet<>();

    private Profile profile;

    @JsonIgnore
    public Long getId() {
        return id;
    }

    @JsonIgnore
    @Override
    public String getUsername() {
        return username;
    }

    @JsonIgnore
    public void setUsername(String username) {
        this.username = this.username;
    }

    @JsonIgnore
    @Override
    public String getPassword() {
        return encryptedPassword;
    }

    @JsonIgnore
    public void setPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    @JsonIgnore
    public Boolean getEnabled() {
        return enabled;
    }

    @JsonIgnore
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    @JsonIgnore
    public LocalDateTime getCreated() {
        return created;
    }

    @JsonIgnore
    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    @JsonIgnore
    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    @JsonIgnore
    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }

    @JsonIgnore
    public Long getVersion() {
        return version;
    }

    @JsonIgnore
    public void setVersion(Long version) {
        this.version = version;
    }

    @JsonIgnore
    public Set<RoledUser> getRoledUsers() {
        return roledUsers;
    }

    @JsonIgnore
    public void setRoledUsers(Set<RoledUser> roledUsers) {
        this.roledUsers = roledUsers;
    }

    @JsonIgnore
    public Set<UserTasks> getUserTasks() {
        return userTasks;
    }

    @JsonIgnore
    public void setUserTasks(Set<UserTasks> userTasks) {
        this.userTasks = userTasks;
    }

    @JsonIgnore
    public Profile getProfile() {
        return profile;
    }

    @JsonIgnore
    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>();
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
