package com.project1.demo.data.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="USER")
public class User {
    @Id
    @Email
    @NotEmpty
    @Column(name = "EMAILADDRESS", nullable = false, unique = true)
    private String emailAddress;
    @NotEmpty(message = "Please, enter the first name *from user annotation*")
    @Column(name = "FIRSTNAME", nullable = false)
    private String firstName;
    @NotEmpty
    @Column(name = "LASTNAME", nullable = false)
    private String lastName;
    @Column(name = "TEAM")
    private String team;
    @Column(name = "NUMBER")
    private double number;
    @Column(name = "POSITION")
    private String position;
    @Column(name = "BIRTHDAY")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;
    @Column(name = "WEIGHT")
    private double weight;
    @Column(name = "HEIGHT")
    private double height;
    @Column(name = "NATIONALITY")
    private String nationality;
    @Column(name = "NAMEFIELD")
    private String namefield;
    @NotEmpty (message = "The above field must not be blank")
    @Size(min = 5, message = "The password must have at least 5 characters")
    @Column(name = "PASSWORD", nullable = false)
    private String password;

//    @NotEmpty
    @ManyToMany (cascade = CascadeType.ALL)
    @JoinTable (name = "USER_ROLES", joinColumns = {
            @JoinColumn(name="USER_EMAILADDRESS", referencedColumnName = "EMAILADDRESS")
    }, inverseJoinColumns = {@JoinColumn(name="ROLE_ROLENAME", referencedColumnName = "ROLENAME")})
//    @Column(name = "ROLES", nullable = false)
    @Column(name = "ROLES")
    private List<Role> roles;


    public User(String firstName, String lastName, String emailAddress, String team, double number, String position, LocalDate birthday, double weight, double height, String nationality, String namefield, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.team = team;
        this.number = number;
        this.position = position;
        this.birthday = birthday;
        this.weight = weight;
        this.height = height;
        this.nationality = nationality;
        this.namefield = namefield;
        this.password = password;
//        this.roles = roles;
    }

    public User() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public double getNumber() {
        return number;
    }

    public void setNumber(double number) {
        this.number = number;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getNamefield() {
        return namefield;
    }

    public void setNamefield(String namefield) {
        this.namefield = namefield;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}