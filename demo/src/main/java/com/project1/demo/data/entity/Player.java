package com.project1.demo.data.entity;


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
    @Column(name = "FIRST_NAME")
    private String first_Name;
    @Column(name = "LAST_NAME")
    private String Last_Name;
    @Column(name = "EMAIL_ADDRESS")
    private String email_Address;
    @Column(name = "TEAM")
    private String team;
    @Column(name = "NUMBER")
    private double number;
    @Column(name = "POSITION")
    private String position;
    @Column(name = "BIRTHDAY")
    private Date birthday;
    @Column(name = "WEIGHT")
    private double weight;
    @Column(name = "HEIGHT")
    private double height;
    @Column(name = "NATIONALITY")
    private String nationality;
    @Column(name = "NAMEFIELD")
    private String namefield;

    public Player(long id, String first_Name, String last_Name, String email_Address, String team, double number, String position, Date birthday, double weight, double height, String nationality, String namefield) {
        this.id = id;
        this.first_Name = first_Name;
        Last_Name = last_Name;
        this.email_Address = email_Address;
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

    public String getFirst_Name() {
        return first_Name;
    }

    public void setFirst_Name(String first_Name) {
        this.first_Name = first_Name;
    }

    public String getLast_Name() {
        return Last_Name;
    }

    public void setLast_Name(String last_Name) {
        Last_Name = last_Name;
    }

    public String getEmail_Address() {
        return email_Address;
    }

    public void setEmail_Address(String email_Address) {
        this.email_Address = email_Address;
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
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