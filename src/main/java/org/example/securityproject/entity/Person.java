package org.example.securityproject.entity;



import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "PERSONS")
@IdClass(PersonId.class)
public class Person implements Serializable {
    @Id
    @Column(name = "name")
    private String name;

    @Id
    @Column(name = "surname")
    private String surname;

    @Id
    @Column(name = "age")
    private int age;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "city_of_living")
    private String cityOfLiving;
    @Column(name="permissions")
    private Enum permissions;

    public void setPermissions(Enum permissions) {
        this.permissions = permissions;
    }

    public Enum getPermissions() {
        return permissions;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getCityOfLiving() {
        return cityOfLiving;
    }



    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setCityOfLiving(String cityOfLiving) {
        this.cityOfLiving = cityOfLiving;
    }
}