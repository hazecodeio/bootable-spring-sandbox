package org.hsmak.jpaWithCrudRepositoryAndBidirMappings.entity;

import org.hsmak.jpaWithCrudRepositoryAndBidirMappings.entity.User;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "project_code")
    private int projectCode;

    @Column(name = "project_name")
    private String projectName;

    @ManyToMany(mappedBy = "projects", fetch = FetchType.EAGER)
    private Set<User> users;


    public Project(int projectCode, String projectName, Set<User> users) {
        this.projectCode = projectCode;
        this.projectName = projectName;
        this.users = users;
    }

    public Project() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(int projectCode) {
        this.projectCode = projectCode;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", projectCode=" + projectCode +
                ", projectName='" + projectName + '\'' +
                '}';
    }
}
