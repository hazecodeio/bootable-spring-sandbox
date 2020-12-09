package org.hsmak.jpaWithCrudRepositoryAndUnidirMappings.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password")
    private String password;

    @OneToOne(cascade = CascadeType.ALL) // Unidirectional
    @JoinColumn(name = "user_details_id")
    private UserDetails userDetails;

    /*
     * Must be Eager, WHY?? the (n + 1) problem
     *  - Link: https://www.baeldung.com/hibernate-initialize-proxy-exception
     */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)// UniDirectional
    @JoinColumn(name = "user_id")
    // This map the primary key of User as a FK inn the target instead of creating a separate table for the mapping
    private Set<Address> addresses;


    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER) // UniDirectional
    @JoinTable(name = "user_project",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "project_id")}
    )
    private Set<Project> projects;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", userDetails=" + userDetails +
                ", addresses=" + addresses +
                ", projects=" + projects +
                '}';
    }
}
