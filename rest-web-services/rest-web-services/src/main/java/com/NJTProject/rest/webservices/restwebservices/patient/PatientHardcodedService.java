/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.NJTProject.rest.webservices.restwebservices.patient;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Andjela
 */
@Service
class PatientHardcodedService {

    private static List<Patient> patients = new ArrayList<Patient>();
    private static long idCounter = 0;

    static {

//        patients.add(new Patient(++idCounter, "123456", "Patient", "First", new Date(), "1@gmail.com", "12345678", "first"));
//        patients.add(new Patient(++idCounter, "123456", "Patient", "Second", new Date(), "2@gmail.com", "0123457", "second"));
//        patients.add(new Patient(++idCounter, "12154", "Patient", "Thirs", new Date(), "3@gmail.com", "123474841", "third"));

    }

    public List<Patient> findAll() {
        return patients;
    }

    public Patient deletePatientById(String id) {
        Patient patient = findPatientById(id);
        patients.remove(patient);
        if (patient == null) {
            return null;
        }
        return patient;
    }

    public Patient findPatientById(String id) {
        for (Patient patient : patients) {
            if (patient.getId().equals(id)) {
                return patient;
            }
        }
        return null;
    }

    public Patient save(Patient p) {
       
        if (p.getId()==null | p.getId().equals("-1")) {
            p.setId(++idCounter);
            patients.add(p);

        } else {
            deletePatientById(p.getId()+"");
            patients.add(p);
        }
        return p;

    }


}
