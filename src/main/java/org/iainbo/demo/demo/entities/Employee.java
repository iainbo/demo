package org.iainbo.demo.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;


import javax.persistence.*;

@Data
@Entity
public class Employee {

    private @Id @GeneratedValue Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String emailAddress;
    private String address;

    private @Version @JsonIgnore Long version;

    private @ManyToOne
    Manager manager;

    private Employee(){

    }

    public Employee(String firstName, String lastName, String phoneNumber, String emailAddress, String address, Manager manager){
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.address = address;
        this.manager = manager;
    }
}