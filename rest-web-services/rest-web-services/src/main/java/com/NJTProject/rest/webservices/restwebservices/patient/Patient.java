/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.NJTProject.rest.webservices.restwebservices.patient;

import com.NJTProject.rest.webservices.restwebservices.Report.Report;
import com.NJTProject.rest.webservices.restwebservices.Review.Review;
import java.util.Date;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;




/**
 *
 * @author Andjela
 */

@Entity
//@Table(name="..")

public class Patient {
	@Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String UCIN;
    private String name;
    private String surname;
    private Date birthdate;
    private String email;
    private String telephone;
    private String password;
    
    @OneToMany(cascade = CascadeType.ALL)
    Set<Review> reviews;
//    @OneToMany(  cascade = CascadeType.ALL)
//    Set<Report> reports;

    public Patient() {
    }

//    public Patient(Long id, String UCIN, String name, String surname, Date birthdate, String email, String telephone, String password) {
//        this.id = id;
//        this.UCIN = UCIN;
//        this.name = name;
//        this.surname = surname;
//        this.birthdate = birthdate;
//        this.email = email;
//        this.telephone = telephone;
//        this.password = password;
////        this.reports=reports;
////        this.reviews=reviews;
//    }
//    

  

    public Patient(Long id, String uCIN, String name, String surname, Date birthdate, String email, String telephone,
			String password, Set<Review> reviews) {
		super();
		this.id = id;
		UCIN = uCIN;
		this.name = name;
		this.surname = surname;
		this.birthdate = birthdate;
		this.email = email;
		this.telephone = telephone;
		this.password = password;
		this.reviews = reviews;
//		this.reports = reports;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public Set<Review> getReviews() {
		return reviews;
	}

	public void setReviews(Set<Review> reviews) {
		this.reviews = reviews;
	}

//	public Set<Report> getReports() {
//		return reports;
//	}
//
//	public void setReports(Set<Report> reports) {
//		this.reports = reports;
//	}

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
     * @return the UCIN
     */
    public String getUCIN() {
        return UCIN;
    }

    /**
     * @param UCIN the UCIN to set
     */
    public void setUCIN(String UCIN) {
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
        return birthdate;
    }

    /**
     * @param birthDate the birthDate to set
     */
    public void setBirthDate(Date birthDate) {
        this.birthdate = birthDate;
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

  

    
    @Override
	public String toString() {
		return "Patient [id=" + id + ", UCIN=" + UCIN + ", name=" + name + ", surname=" + surname + ", birthDate="
				+ birthdate + ", email=" + email + ", telephone=" + telephone + ", password=" + password + ", doctor="
				+ "]";
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