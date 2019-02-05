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
    private List<Player> players;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Player> getPlayerList() {
        return players;
    }

    public void setPlayerList(List<Player> playerList) {
        this.players = playerList;
    }

    public Role(String name, List<Player> playerList) {
        this.name = name;
        this.players = playerList;
    }
    public Role() {
    }

//    public Role(String name) {
    public Role(@NotEmpty String name) {
        this.name = name;
    }
}
