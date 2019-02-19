package ua.pp.darknsoft.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name = "Solution")
@Table(name = "solutions")
public class Solution {
    @Version
    private Long version;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "solution_gen")
    @SequenceGenerator(name="solution_gen", sequenceName = "solution_seq", allocationSize=1)
    @NotNull
    private Long id;

    @NotNull
    private String content;

    @Enumerated(value = EnumType.STRING)
    @NotNull
    private Passed passed;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_id")
    @NotNull
    private Task task;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @NotNull
    private User user;

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

    public String getContent() {
        return content;
    }
    public Solution setContent(String content) {
        this.content = content;
        return this;
    }

    public Passed getPassed() {
        return passed;
    }
    public Solution setPassed(Passed passed) {
        this.passed = passed;
        return this;
    }

    public Task getTask() {
        return task;
    }
    public Solution setTask(Task task) {
        this.task = task;
        return this;
    }

    public User getUser() {
        return user;
    }
    public Solution setUser(User user) {
        this.user = user;
        return this;
    }

}
