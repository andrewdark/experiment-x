package ua.pp.darknsoft.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Solution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean passed;
    @Version
    private Long version;
    @Lob
    @NotNull
    @Column(nullable = false)
    private String code;

    //private UserTasks userTasks;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getPassed() {
        return passed;
    }

    public void setPassed(Boolean passed) {
        this.passed = passed;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

//    public UserTasks getUserTasks() {
//        return userTasks;
//    }
//
//    public void setUserTasks(UserTasks userTasks) {
//        this.userTasks = userTasks;
//    }
}
