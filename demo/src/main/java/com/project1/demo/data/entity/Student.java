package com.project1.demo.data.entity;


import javax.persistence.*;

@Entity
@Table(name="STUDENT")
public class Student {
    @Id
    @Column(name="STUDENT_ID")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    @Column(name="NAME")
    private String name;
    @Column(name="EMAIL_ADDRESS")
    private String email_Address;
    @Column(name="PURCHASE_PACKAGE")
    private String purchase_Package;

    public Student(String name, String email_Address, String purchase_Package) {
        this.name = name;
        this.email_Address = email_Address;
        this.purchase_Package = purchase_Package;
    }

    public Student() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail_Address() {
        return email_Address;
    }

    public void setEmail_Address(String email_Address) {
        this.email_Address = email_Address;
    }

    public String getPurchase_Package() {
        return purchase_Package;
    }

    public void setPurchase_Package(String purchase_Package) {
        this.purchase_Package = purchase_Package;
    }
}
