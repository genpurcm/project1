package com.project1.demo.data.entity;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name="PLAYER")
public class Player {
    @Id
    @Column(name = "PLAYER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "FIRSTNAME")
    private String firstName;
    @Column(name = "LASTNAME")
    private String lastName;
    @Column(name = "EMAILADDRESS")
    private String emailAddress;
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

    public Player(long id, String firstName, String lastName, String emailAddress, String team, double number, String position, LocalDate birthday, double weight, double height, String nationality, String namefield) {
        this.id = id;
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
    }

    public Player() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
}