package ua.pp.darknsoft.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "user_tasks")
@org.hibernate.annotations.Immutable
public class UserTasks {
    @Embeddable
    public static class Id implements Serializable {
        @Column(name = "user_id")
        protected Long userId;
        @Column(name = "task_id")
        protected Long taskId;

        public Id() {
        }

        public Id(Long userId, Long taskId) {
            this.userId = userId;
            this.taskId = taskId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Id)) return false;
            Id id = (Id) o;
            return userId.equals(id.userId) &&
                    taskId.equals(id.taskId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(userId, taskId);
        }
    }

    @EmbeddedId
    private Id id;
    @Column(updatable = false, nullable = false)
    @NotNull
    private LocalDateTime addedOn = LocalDateTime.now();
    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private AppUser appUser;
    @ManyToOne
    @JoinColumn(name = "task_id", insertable = false, updatable = false)
    private Task task;

    @OneToOne(fetch = FetchType.LAZY, optional = false, cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true)
    @JoinColumn(unique = true)
    private Solution solution;

    public UserTasks() {
    }

    public UserTasks(AppUser appUser, Task task) {
        this.appUser = appUser;
        this.task = task;
        this.id.userId = appUser.getId();
        this.id.taskId = task.getId();
        appUser.getUserTasks().add(this);
        task.getUserTasks().add(this);
    }

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }

    public LocalDateTime getAddedOn() {
        return addedOn;
    }

    public void setAddedOn(LocalDateTime addedOn) {
        this.addedOn = addedOn;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Solution getSolution() {
        return solution;
    }

    public void setSolution(Solution solution) {
        this.solution = solution;
    }
}
