package com.NJTProject.rest.webservices.restwebservices.Review;

import com.NJTProject.rest.webservices.restwebservices.Report.Report;
import com.NJTProject.rest.webservices.restwebservices.doctor.Doctor;
import com.NJTProject.rest.webservices.restwebservices.patient.Patient;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Review implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Basic
    @DateTimeFormat
    private Date date;
    private String description;
    private String office;

//  @ManyToOne(cascade = CascadeType.ALL)
    @ManyToOne
    @JoinColumn(name = "patientid", referencedColumnName = "id")
    private Patient patient;

//   @ManyToOne(cascade = CascadeType.ALL)
    @ManyToOne
    @JoinColumn(name = "doctorid")
    private Doctor doctor;

    @OneToMany(mappedBy = "review",cascade = CascadeType.ALL)
    private Set<Report> reports;
    
   

    public Review() {
    }

    public Review(Long id, Date date, String description, String office, Patient patient, Doctor doctor, Set<Report> reports) {
        this.id = id;
        this.date = date;
        this.description = description;
        this.office = office;
        this.patient = patient;
        this.doctor = doctor;
        this.reports = reports;
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
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the office
     */
    public String getOffice() {
        return office;
    }

    /**
     * @param office the office to set
     */
    public void setOffice(String office) {
        this.office = office;
    }

    /**
     * @return the patient
     */
    public Patient getPatient() {
        return patient;
    }

    /**
     * @param patient the patient to set
     */
    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    /**
     * @return the doctor
     */
    public Doctor getDoctor() {
        return doctor;
    }

    /**
     * @param doctor the doctor to set
     */
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    /**
     * @return the reports
     */
    public Set<Report> getReports() {
        return reports;
    }

    /**
     * @param reports the reports to set
     */
    public void setReports(Set<Report> reports) {
        this.reports = reports;
    }

   


   

}
