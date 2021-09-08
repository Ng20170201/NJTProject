package com.NJTProject.rest.webservices.restwebservices.Review;

import com.NJTProject.rest.webservices.restwebservices.doctor.Doctor;
import com.NJTProject.rest.webservices.restwebservices.doctor.DoctorJpaRepository;
import com.NJTProject.rest.webservices.restwebservices.patient.Patient;
import com.NJTProject.rest.webservices.restwebservices.patient.PatientsJpaRepository;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ReviewsJpaResource {

    @Autowired
    private ReviewJpaRepository reviewJpaRepository;

    @Autowired
    private DoctorJpaRepository doctorJpaRepository;
    @Autowired
    private PatientsJpaRepository patientsJpaRepository;

    /*
    @GetMapping("/jpa/users/{username}/reviews")
    public List<Review> getAllReviews(@PathVariable String username) {
        //	return ReviewService.findAll();
         Doctor d1=doctorJpaRepository.findByUsername(username);
        List<Review> reviews = reviewJpaRepository.findAll();
        
        for (Review r : reviews) {

            System.out.println("Procitao:" + r);
        }
        return reviewJpaRepository.findAll();
    }*/
    @GetMapping("/jpa/users/{username}/reviews")
    public List<Review> getAllReviews(@PathVariable String username) {
        List<Review> reviews = reviewJpaRepository.findAll();
        //ako je doktor
        Doctor d1 = doctorJpaRepository.findByUsername(username);
        List<Review> finalReviews = new ArrayList<>();
        if (d1 != null) {
            System.out.println("DOKTOR JE");
            for (Review r : reviews) {
                if (r.getDoctor().getUsername().equals(username)) {
                    finalReviews.add(r);
                }
            }
        }
        //ako je pacijent
        Patient p1 = patientsJpaRepository.findByUCIN(username);
        if (p1 != null) {
            System.out.println("PACIJENT JE");
            for (Review r : reviews) {
                if (r.getPatient().getUCIN().equals(username)) {
                    finalReviews.add(r);
                }
            }
        }
        return finalReviews;
    }

    @GetMapping("/jpa/users/{username}/reviews/{id}")
    public Review getReview(@PathVariable String username, @PathVariable long id) {
        return reviewJpaRepository.findById(id);
		

    }
// return this.http.delete(`${REPORT_JPA_API_URL}/users/admin/reviews/${id}/${idP}/${idD}`);

    @DeleteMapping("/jpa/users/{username}/reviews/{id}/{patientid}/{doctorid}")
    public ResponseEntity<Void> deleteReview(@PathVariable String username, @PathVariable long id, @PathVariable long patientid, @PathVariable long doctorid) {
        reviewJpaRepository.deleteById(id);
        return ResponseEntity.noContent().build();

    }

    /* @DeleteMapping("/jpa/users/{username}/reviews/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable String username, @PathVariable long id) {
       reviewJpaRepository.deleteById(id);
      return ResponseEntity.noContent().build();

    }*/
//return this.http.put(`${REPORT_JPA_API_URL}/users/${username}/reviews/${id}`,reviewDb);
    @PutMapping("/jpa/users/{username}/reviews/{id}")
    public ResponseEntity<Review> updateReview(@PathVariable String username, @PathVariable long id, @RequestBody Review review) {
        Review reviewUpdate = reviewJpaRepository.save(review);
        return new ResponseEntity<Review>(review, HttpStatus.OK);
    }

    @PostMapping("/jpa/users/{username}/reviews")
    public ResponseEntity createReview(@PathVariable String username, @RequestBody Review review) {
        Doctor d1 = doctorJpaRepository.findByUsername(username);
        review.setDoctor(d1);
        System.out.println("ovo je rev new " + review);
        Review createdReview = reviewJpaRepository.save(review);
        System.out.println("TREBA DA SE DODA: " + review);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
                path("/{doctorId}/{patientId}").buildAndExpand(createdReview.getDoctor().getId(), createdReview.getPatient().getId()).toUri();

        return ResponseEntity.ok(review);
    }

}
