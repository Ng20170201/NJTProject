package com.NJTProject.rest.webservices.restwebservices.Report;

import java.net.URI;
import java.util.List;

import javax.servlet.Servlet;

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
public class ReportsResource {
	@Autowired
	private ReportHardcodeService ReportService;

	@GetMapping("/users/{username}/reports")
	public List<Report> getAllReports(@PathVariable String username){
		return ReportService.findAll();
		
	}
	@GetMapping("/users/{username}/reports/{doctorId}/{patientId}")
	public Report getReport(@PathVariable String username, @PathVariable long patientId,@PathVariable long doctorId){
		return ReportService.findById(doctorId,patientId);
		
	}
	
	
	@DeleteMapping("/users/{username}/reports/{doctorId}/{patientId}")
	public ResponseEntity<Void> deleteReport(@PathVariable String username, @PathVariable long patientId,@PathVariable long doctorId){
		Report report=ReportService.deleteById(doctorId, patientId);
		
		if(report!=null) {
			return ResponseEntity.noContent().build();
		}
		return  ResponseEntity.notFound().build();
		
	}
	@PutMapping("/users/{username}/reports/{doctorId}/{patientId}")
	public  ResponseEntity<Report> updateReport(@PathVariable String username, @PathVariable long patientId,@PathVariable long doctorId, @RequestBody Report report){
		Report reportUpdate=ReportService.save(report);
		return new ResponseEntity<Report>(report,HttpStatus.OK);
	}
	@PostMapping("/users/{username}/reports")
	public  ResponseEntity<Void> updateReport(@PathVariable String username, @RequestBody Report report){
		Report createdReport=ReportService.save(report);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
			 path("/{doctorId}/{patientId}").buildAndExpand(createdReport.getDoctorID(),createdReport.getPatientID()).toUri();
	
		
		
		return ResponseEntity.created(uri).build();
	}
	
	
	
}


