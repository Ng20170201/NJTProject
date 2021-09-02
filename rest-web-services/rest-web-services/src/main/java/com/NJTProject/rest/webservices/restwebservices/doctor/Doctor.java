/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.NJTProject.rest.webservices.restwebservices.doctor;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Andjela
 */

public class Doctor {
    @Override
	public String toString() {
		return "Doctor [id=" + id + ", name=" + name + ", surname=" + surname + ", specialization=" + specialization
				+ ", workingShift=" + workingShift + ", username=" + username + ", password=" + password + "]";
	}

	private String id;
    private String name;
    private String surname;
    private String specialization;
    private String workingShift;
    private String username;
    private String password;

    public Doctor() {
    }

    public Doctor(String id, String name, String surname, String specialization, String workingShift, String username, String password) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.specialization = specialization;
        this.workingShift = workingShift;
        this.username = username;
        this.password = password;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
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
     * @return the workingShift
     */
    public String getWorkingShift() {
        return workingShift;
    }

    /**
     * @param workingShift the workingShift to set
     */
    public void setWorkingShift(String workingShift) {
        this.workingShift = workingShift;
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
    
    
}
