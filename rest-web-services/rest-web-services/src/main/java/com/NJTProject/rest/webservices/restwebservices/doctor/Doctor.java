/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.NJTProject.rest.webservices.restwebservices.doctor;

import com.NJTProject.rest.webservices.restwebservices.Department.Department;
import com.NJTProject.rest.webservices.restwebservices.Review.Review;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Andjela
 */
@Entity
public class Doctor {
    @Id
    private Long id;
    private String name;
    private String surname;
    private String specialization;
    private String workingshift;
    private String username;
    private String password;
    
    @ManyToOne
    @JoinColumn(name="departmentid")
    private Department department;
    
    @OneToMany(mappedBy="doctor",cascade = CascadeType.ALL)
    Set<Review>reviews;

    public Doctor() {
    }

    public Doctor(Long id, String name, String surname, String specialization, String workingshift, String username, String password, Department department) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.specialization = specialization;
        this.workingshift = workingshift;
        this.username = username;
        this.password = password;
        this.department = department;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * @param surname the surname to set
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * @return the specialization
     */
    public String getSpecialization() {
        return specialization;
    }

    /**
     * @param specialization the specialization to set
     */
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    /**
     * @return the workingshift
     */
    public String getWorkingshift() {
        return workingshift;
    }

    /**
     * @param workingshift the workingshift to set
     */
    public void setWorkingshift(String workingshift) {
        this.workingshift = workingshift;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the department
     */
    public Department getDepartment() {
        return department;
    }

    /**
     * @param department the department to set
     */
    public void setDepartment(Department department) {
        this.department = department;
    }

  

}