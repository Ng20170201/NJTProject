package com.NJTProject.rest.webservices.restwebservices.Report;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.NJTProject.rest.webservices.restwebservices.doctor.Doctor;
import com.NJTProject.rest.webservices.restwebservices.patient.Patient;

import java.util.Date;
import java.util.ArrayList;


@Service
public class ReportHardcodeService {
		private static List<Report> reports=new ArrayList();
		private static long idCounter=0;
		
		static {
			reports.add(new Report(++idCounter,"Diagnosys1","Therapy1","Note1"));
			reports.add(new Report(++idCounter,"Diagnosys2","Therapy2","Note2"));
			reports.add(new Report(++idCounter,"Diagnosys3","Therapy3","Note3"));
		}
		public List<Report> findAll(){
			return reports;
		}
		
		public Report deleteById(long id) {
			Report report=findById(id);
			if(report==null) return null;
			if(reports.remove(report)) {
			return report;
			}
			return null;
		
		}

		Report findById(long id) {
			for(Report report:reports) {
				if(report.getId()==id ) {
					return report;
				}
			}
			return null;
		}
		public Report save(Report report) {
			if(report.getId()==-1 || report.getId()==0) {
				report.setId(++idCounter);
				reports.add(report);
				
			}
			else {
				deleteById(report.getId());
				reports.add(report);
			}
			return report;
		}
}