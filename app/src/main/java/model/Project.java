package model;

import java.util.Date;
import java.util.Objects;

public class Project {

    private int id;
    private String name;
    private String description;
    private Date creationAt;
    private Date updateAt;

    public Project(int id, String name, String description, Date creationAt, Date updateAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.creationAt = creationAt;
        this.updateAt = updateAt;
    }

    public Project() {
        this.creationAt = new Date();
        if (this.updateAt == null) {
            this.updateAt = new Date();
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Date getCreationAt() {
        return creationAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreationAt(Date creationAt) {
        this.creationAt = creationAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + this.id;
        hash = 17 * hash + Objects.hashCode(this.creationAt);
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
        final Project other = (Project) obj;
        if (this.id != other.id) {
            return false;
        }
        return Objects.equals(this.creationAt, other.creationAt);
    }

    @Override
    public String toString() {
        return this.getName();
    }

}
