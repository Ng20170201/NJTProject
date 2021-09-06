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

    @GetMapping("/jpa/users/{username}/reviews/{id}")
    public Review getReview(@PathVariable String username, @PathVariable long id) {
        return reviewJpaRepository.findById(id).get();

    }
// return this.http.delete(`${REPORT_JPA_API_URL}/users/admin/reviews/${id}/${idP}/${idD}`);

      @DeleteMapping("/jpa/users/{username}/reviews/{id}/{patientid}/{doctorid}")
    public ResponseEntity<Void> deleteReview(@PathVariable String username, @PathVariable long id,@PathVariable long patientid,@PathVariable long doctorid) {
       reviewJpaRepository.deleteByIdAndPatientAndDoctor(id,patientid,doctorid);
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
        
        Review createdReview = reviewJpaRepository.save(review);
        System.out.println("TREBA DA SE DODA: " + review);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
                path("/{doctorId}/{patientId}").buildAndExpand(createdReview.getDoctor().getId(), createdReview.getPatient().getId()).toUri();

        return ResponseEntity.ok(review);
    }

}
