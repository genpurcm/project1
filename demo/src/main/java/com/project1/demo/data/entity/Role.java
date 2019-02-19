package com.project1.demo.data.entity;//package com.project1.demo.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Table(name="ROLE")
public class Role {
    @Id
    @NotEmpty
    @Column(name = "ROLENAME", length = 10)
    private String name;
    @ManyToMany(mappedBy = "roles")
    @JsonIgnore
    @Column(name = "USERLIST")
    private List<User> users;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Role(String name, List<User> users) {
        this.name = name;
        this.users = users;
    }
    public Role() {
    }
    public Role(@NotEmpty String name) {
        this.name = name;
    }
}
