package org.hsmak.jpaWithCrudRepositoryAndUnidirMappings.entity;

import javax.persistence.*;

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

    public Project(int projectCode, String projectName) {
        this.projectCode = projectCode;
        this.projectName = projectName;
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

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", projectCode=" + projectCode +
                ", projectName='" + projectName + '\'' +
                '}';
    }
}
