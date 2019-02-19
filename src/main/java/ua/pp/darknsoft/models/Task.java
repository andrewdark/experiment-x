package ua.pp.darknsoft.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name = "Task")
@Table(name = "tasks")
public class Task {
    @Version
    private Long version;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_gen")
    @SequenceGenerator(name="task_gen", sequenceName = "task_seq", allocationSize=1)
    @NotNull
    private Long id;

    @Lob
    @NotNull
    private String description;

    @NotNull
    private String name;

    @NotNull
    private String signature;

    @Enumerated(value = EnumType.STRING)
    @NotNull
    private Level level;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "task_tag", joinColumns = @JoinColumn(name = "task_id"), inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private Set<Tag> tags = new HashSet<>();

    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Test> tests = new ArrayList<>();

    @ManyToMany(mappedBy = "tasks")
    private Set<User> users = new HashSet<>();

    public Task() {}

    public Long getVersion() {
        return version;
    }
    public Task setVersion(Long version) {
        this.version = version;
        return this;
    }

    public Long getId() {
        return id;
    }
    public Task setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }
    public Task setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getName() {
        return signature;
    }
    public Task setName(String name) {
        this.signature = signature;
        return this;
    }

    public String getSignature() {
        return signature;
    }
    public Task setSignature(String signature) {
        this.signature = signature;
        return this;
    }

    public Level getLevel() {
        return level;
    }
    public Task setLevel(Level level) {
        this.level = level;
        return this;
    }

    public Set<Tag> getTags() {
        return tags;
    }
    public Task setTags(Set<Tag> tags) {
        this.tags = tags;
        return this;
    }

    public void addTag(Tag tag) {
        tags.add(tag);
        tag.getTasks().add(this);
    }
    public void removeTag(Tag tag) {
        tags.remove(tag);
        tag.getTasks().remove(this);
    }

    public void addTest(Test test) {
        tests.add(test);
        test.setTask(this);
    }
    public void removeTest(Test test) {
        tests.remove(test);
        test.setTask(null);
    }

    public void addUser(User user) {
        users.add(user);
        user.getTasks().add(this);
    }
    public void removeUser(User user) {
        users.remove(user);
        user.getTasks().remove(this);
    }
}
