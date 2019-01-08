package ua.pp.darknsoft.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "task", uniqueConstraints = {@UniqueConstraint(name = "APP_TASK_UC", columnNames = "task_name")})
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "task_name", nullable = false)
    private String taskName;
    @Lob
    private String description;
    @Enumerated(value = EnumType.STRING)
    private Level level;
    @ManyToMany(mappedBy = "tasks")
    private Set<Tag> tags = new HashSet<Tag>();
    @Version
    private Long version;
    @OneToMany(mappedBy = "task")
    private Set<UserTasks> userTasks = new HashSet<>();
    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Test> tests = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Set<UserTasks> getUserTasks() {
        return userTasks;
    }

    public void setUserTasks(Set<UserTasks> userTasks) {
        this.userTasks = userTasks;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }
}
