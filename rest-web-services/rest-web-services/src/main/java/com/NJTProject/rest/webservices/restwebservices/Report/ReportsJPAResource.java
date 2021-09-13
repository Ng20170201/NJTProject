package com.NJTProject.rest.webservices.restwebservices.Report;

import com.NJTProject.rest.webservices.restwebservices.Review.Review;
import com.NJTProject.rest.webservices.restwebservices.Review.ReviewJpaRepository;
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


@CrossOrigin(origins="http://localhost:4200")
@RestController
public class ReportsJPAResource {
	@Autowired
	private ReportHardcodeService ReportService;
	
	@Autowired
	private ReportJpaRepository reportJpaRepository;
	@Autowired
	private ReviewJpaRepository reviewJpaRepository;
	@Autowired
	private DoctorJpaRepository doctorJpaRepository;
	@Autowired
	private PatientsJpaRepository patientsJpaRepository;
	
	
	@GetMapping("/jpa/users/{username}/reports")
	public List<Report> getAllReports(@PathVariable String username){
//		return ReportService.findAll();
		List<Report> reports= reportJpaRepository.findAll();
	
		Doctor doctor= doctorJpaRepository.findByUsername(username);
		
		Patient patient= patientsJpaRepository.findByUCIN(username);
		
		List<Report> ReturnReports= new ArrayList<Report>();
		
		if(doctor!=null) {
		
		for(int i=0;i<reports.size();i++) {
			if(reports.get(i).s().getDoctor().getId()==doctor.getId())
				ReturnReports.add(reports.get(i));
		}
		}
		if(patient!=null) {
			
			for(int i=0;i<reports.size();i++) {
				if(reports.get(i).s().getPatient().getUCIN().equals(patient.getUCIN()))
					ReturnReports.add(reports.get(i));
		}

		

		
	}
                System.out.println("Vratio sam ove REPORTS sa ovim REVIEWS: ");
                    for(Report r : ReturnReports){
                        System.out.println(r+" \nREVIEW: "+r.s());
                    }
		return ReturnReports;
	}
	@GetMapping("/jpa/users/{username}/reports/{id}")
	public Report getReport(@PathVariable String username, @PathVariable long id){
//		return ReportService.findById(id);
//		System.out.println(reportJpaRepository.findById(id).get());
		Report r1=reportJpaRepository.findById(id);
		
		
		return r1;
		
	
		
	}
	
	
	@DeleteMapping("/jpa/users/{username}/reports/{id}")
	public ResponseEntity<Void> deleteReport(@PathVariable String username, @PathVariable long id){
//		Report report=ReportService.deleteById(id);
		reportJpaRepository.deleteById(id);
		
		return  ResponseEntity.noContent().build();
		
	}
	@PutMapping("/jpa/users/{username}/reports/{id}")
	public  ResponseEntity<Report> updateReport(@PathVariable String username, @PathVariable long id, @RequestBody Report report){
	//	Report reportUpdate=ReportService.save(report);		
		Report report1=reportJpaRepository.findById(id);
		Review r=report1.s();
		 report.se(r);
		 System.out.println("-------"+r);
		Report reportUpdated= reportJpaRepository.save(report);
//		List<Review> reviews=reviewJpaRepository
		return new ResponseEntity<Report>(reportUpdated,HttpStatus.OK);
	}

	@PostMapping("/jpa/users/{username}/reports/{idReview}/{id}")
	public  ResponseEntity<Void> CreateReport(@PathVariable String username,@PathVariable long idReview,@PathVariable long id, @RequestBody Report report){
		Review r1=reviewJpaRepository.findById(idReview);
		List<Review> rev=reviewJpaRepository.findAll();
                
		
		report.se(r1);
		Report createdReport= reportJpaRepository.save(report);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
			 path("/{id}").buildAndExpand(createdReport.getId()).toUri();
	
		
		
		return ResponseEntity.created(uri).build();
		
	}
	
	
	
	
}


