package com.project1.demo.data.entity;//package com.project1.demo.data.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;


@Entity
@Table(name="ROLE")
public class Role {
    @Id
//    @NotEmpty
    @Column(name = "ROLENAME")
    private String name;
    @ManyToMany(mappedBy = "roles")
    @Column(name = "USERLIST")
    private List<User> users;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getPlayerList() {
        return users;
    }

    public void setPlayerList(List<User> userList) {
        this.users = userList;
    }

    public Role(String name, List<User> userList) {
        this.name = name;
        this.users = userList;
    }
    public Role() {
    }

//    public Role(String name) {
    public Role(@NotEmpty String name) {
        this.name = name;
    }
}
