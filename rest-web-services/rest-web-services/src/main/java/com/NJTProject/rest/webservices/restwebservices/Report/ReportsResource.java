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
	@GetMapping("/users/{username}/reports/{id}")
	public Report getReport(@PathVariable String username, @PathVariable long id){
		return ReportService.findById(id);
		
	}
	
	
	@DeleteMapping("/users/{username}/reports/{id}")
	public ResponseEntity<Void> deleteReport(@PathVariable String username, @PathVariable long id){
		Report report=ReportService.deleteById(id);
		
		if(report!=null) {
			return ResponseEntity.noContent().build();
		}
		return  ResponseEntity.notFound().build();
		
	}
	@PutMapping("/users/{username}/reports/{id}")
	public  ResponseEntity<Report> updateReport(@PathVariable String username, @PathVariable long id, @RequestBody Report report){
		Report reportUpdate=ReportService.save(report);		

		return new ResponseEntity<Report>(report,HttpStatus.OK);
	}

	@PostMapping("/users/{username}/reports/{id}")
	public  ResponseEntity<Void> CreateReport(@PathVariable String username, @RequestBody Report report){
		Report createdReport=ReportService.save(report);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
			 path("/{id}").buildAndExpand(createdReport.getId()).toUri();
	
		
		
		return ResponseEntity.created(uri).build();
		
	}
	
	
	
	
}


