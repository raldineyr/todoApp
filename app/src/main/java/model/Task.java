package model;

import java.util.Date;
import java.util.Objects;

public class Task {

    private int id;
    private int idProject;
    private String name;
    private String description;
    private String notes;
    private boolean isCompleted;
    private Date creationAt;
    private Date updateAt;
    private Date deadLine;

    public Task(int id, int idProject, String name, String description, String notes, boolean isCompleted, Date creationAt, Date updateAt, Date deadLine) {
        this.id = id;
        this.idProject = idProject;
        this.name = name;
        this.description = description;
        this.notes = notes;
        this.isCompleted = isCompleted;
        this.creationAt = creationAt;
        this.updateAt = updateAt;
        this.deadLine = deadLine;
    }

    public Task() {
        this.creationAt = new Date();

    }

    public int getId() {
        return id;
    }

    public int getIdProject() {
        return idProject;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getNotes() {
        return notes;
    }

    public boolean getIsCompleted() {
        return isCompleted;
    }

    public Date getCreationAt() {
        return creationAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public Date getDeadLine() {
        return deadLine;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdProject(int idProject) {
        this.idProject = idProject;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setIsCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public void setCreationAt(Date creationAt) {
        this.creationAt = creationAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public void setDeadLine(Date deadLine) {
        this.deadLine = deadLine;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + this.id;
        hash = 61 * hash + this.idProject;
        hash = 61 * hash + Objects.hashCode(this.creationAt);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Task other = (Task) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.idProject != other.idProject) {
            return false;
        }
        return Objects.equals(this.creationAt, other.creationAt);
    }

    @Override
    public String toString() {
        return "Task{" + "id=" + id + ", idProject=" + idProject + ", name=" + name + ", description=" + description + ", notes=" + notes + ", isCompleted=" + isCompleted + ", creationAt=" + creationAt + ", updateAt=" + updateAt + ", deadLine=" + deadLine + '}';
    }

}
