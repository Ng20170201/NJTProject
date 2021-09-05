/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.NJTProject.rest.webservices.restwebservices.dto.impl;

import com.NJTProject.rest.webservices.restwebservices.dto.Dto;
import java.util.Date;

/**
 *
 * @author Andjela
 */
public class ReviewDto extends Dto{
    //id,patientid,doctorid,date,description,office) 
    private Long id;
    private Long patientid;
    private Long doctorid;
    private String office;
    private String description;
    private Date date;

    public ReviewDto() {
    }

    public ReviewDto(Long id, Long patientid, Long doctorid, String office, String description, Date date) {
        this.id = id;
        this.patientid = patientid;
        this.doctorid = doctorid;
        this.office = office;
        this.description = description;
        this.date = date;
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
     * @return the patientid
     */
    public Long getPatientid() {
        return patientid;
    }

    /**
     * @param patientid the patientid to set
     */
    public void setPatientid(Long patientid) {
        this.patientid = patientid;
    }

    /**
     * @return the doctorid
     */
    public Long getDoctorid() {
        return doctorid;
    }

    /**
     * @param doctorid the doctorid to set
     */
    public void setDoctorid(Long doctorid) {
        this.doctorid = doctorid;
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
    
   
    
}
