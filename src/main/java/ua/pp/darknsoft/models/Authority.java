package ua.pp.darknsoft.models;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Authority")
@Table(name = "authorities")
public class Authority implements GrantedAuthority {
    @Version
    private Long version;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "authotiry_gen")
    @SequenceGenerator(name="authotiry_gen", sequenceName = "authotiry_seq", allocationSize=1)
    @NotNull
    private Long id;

    @Column(name = "name")
    @Enumerated(EnumType.STRING)
    @NotNull
    private AuthorityName name;

    @ManyToMany(mappedBy = "authorities")
    private List<User> users = new ArrayList<>();

    public Long getVersion() {
        return version;
    }
    public void setVersion(Long version) {
        this.version = version;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public AuthorityName getName() {
        return name;
    }
    public void setName(AuthorityName name) {
        this.name = name;
    }

    @Override
    public String getAuthority() { return name.toString(); }
}
