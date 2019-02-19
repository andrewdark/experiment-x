package ua.pp.darknsoft.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name = "Test")
@Table(name = "tests")
public class Test {
    @Version
    private Long version;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "test_gen")
    @SequenceGenerator(name="test_gen", sequenceName = "test_seq", allocationSize=1)
    @NotNull
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_id")
    private Task task;

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

    public String getName() {
        return name;
    }
    public void setName(String testName) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }

    public Task getTask() {
        return this.task;
    }
    public void setTask(Task task) {
        this.task = task;
    }
}
