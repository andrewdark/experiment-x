package ua.pp.darknsoft.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String testName;
    @Version
    private Long version;
    @NotNull
    private String result;
    @ManyToOne(fetch = FetchType.LAZY) //be careful - LAZY
    @JoinColumn(name = "task_id", nullable = false)
    private Task task;
}
