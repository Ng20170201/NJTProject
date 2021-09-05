package com.NJTProject.rest.webservices.restwebservices.Review;

import java.net.URI;
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
    private ReviewHardcodeService ReviewService;
    @Autowired
    private ReviewJpaRepository reviewJpaRepository;

    @GetMapping("/jpa/users/{username}/reviews")
    public List<Review> getAllReviews(@PathVariable String username) {
        //	return ReviewService.findAll();
        List<Review> reviews = reviewJpaRepository.findAll();
        System.out.println("Citam reviews");
        for (Review r : reviews) {

            System.out.println("Procitao:" + r);
        }
        return reviewJpaRepository.findAll();
    }

    @GetMapping("/jpa/users/{username}/reviews/{doctorId}/{patientId}")
    public Review getReview(@PathVariable String username, @PathVariable long patientId, @PathVariable long doctorId) {
        return ReviewService.findById(doctorId, patientId);

    }

    @DeleteMapping("/jpa/users/{username}/reviews/{doctorId}/{patientId}")
    public ResponseEntity<Void> deleteReport(@PathVariable String username, @PathVariable long patientId, @PathVariable long doctorId) {
        Review review = ReviewService.deleteById(doctorId, patientId);

        if (review != null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();

    }

    @PutMapping("/jpa/users/{username}/reviews/{doctorId}/{patientId}")
    public ResponseEntity<Review> updateReview(@PathVariable String username, @PathVariable long patientId, @PathVariable long doctorId, @RequestBody Review review) {
        Review reviewUpdate = ReviewService.save(review);
        return new ResponseEntity<Review>(review, HttpStatus.OK);
    }

    /*
        @PostMapping("/jpa/users/{username}/patients")
    public ResponseEntity<Void> createPatient(@PathVariable String username, @RequestBody Patient patient) {
        System.out.println("Procitan pacijent: " + patient);
        Patient patentAdded = patientsJpaRepository.save(patient);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(patentAdded.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
     */
    @PostMapping("/jpa/users/{username}/reviews")
    public ResponseEntity createReview(@PathVariable String username, @RequestBody Review review) {
        
        Review createdReview = ReviewService.save(review);
        System.out.println("TREBA DA SE DODA: " + review);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
                path("/{doctorId}/{patientId}").buildAndExpand(createdReview.getDoctor().getId(), createdReview.getPatient().getId()).toUri();

        return ResponseEntity.ok(review);
    }

}
