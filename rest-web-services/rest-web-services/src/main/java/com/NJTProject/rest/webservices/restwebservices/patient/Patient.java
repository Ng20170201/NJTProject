/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.NJTProject.rest.webservices.restwebservices.patient;

import com.NJTProject.rest.webservices.restwebservices.doctor.Doctor;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;



/**
 *
 * @author Andjela
 */


public class Patient {

	
    private String id;
    private Integer UCIN;
    private String name;
    private String surname;
    private Date birthDate;
    private String email;
    private String telephone;
    private String password;
    private Doctor doctor;

    public Patient() {
    }

    public Patient(String id, Integer UCIN, String name, String surname, Date birthDate, String email, String telephone, String password, Doctor doctor) {
        this.id = id;
        this.UCIN = UCIN;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.email = email;
        this.telephone = telephone;
        this.password = password;
        this.doctor = doctor;
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
     * @return the UCIN
     */
    public Integer getUCIN() {
        return UCIN;
    }

    /**
     * @param UCIN the UCIN to set
     */
    public void setUCIN(Integer UCIN) {
        this.UCIN = UCIN;
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
     * @return the birthDate
     */
    public Date getBirthDate() {
        return birthDate;
    }

    /**
     * @param birthDate the birthDate to set
     */
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the telephone
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * @param telephone the telephone to set
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
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

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    
    @Override
	public String toString() {
		return "Patient [id=" + id + ", UCIN=" + UCIN + ", name=" + name + ", surname=" + surname + ", birthDate="
				+ birthDate + ", email=" + email + ", telephone=" + telephone + ", password=" + password + ", doctor="
				+ doctor + "]";
	}

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Patient other = (Patient) obj;
        if ((this.id == null) ? (other.id != null) : !this.id.equals(other.id)) {
            return false;
        }
        if (this.UCIN != other.UCIN && (this.UCIN == null || !this.UCIN.equals(other.UCIN))) {
            return false;
        }
        return true;
    }
    
    

}
