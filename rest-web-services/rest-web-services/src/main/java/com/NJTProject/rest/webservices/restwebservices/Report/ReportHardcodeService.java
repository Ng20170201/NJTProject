package com.NJTProject.rest.webservices.restwebservices.Report;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.ArrayList;


@Service
public class ReportHardcodeService {
		private static List<Report> reports=new ArrayList();
		private static int idCounter=0;
		
		static {
			reports.add(new Report(++idCounter,1,"Description1","Office1",new Date()));
			reports.add(new Report(++idCounter,1,"Description2","Office2",new Date()));
			reports.add(new Report(++idCounter,1,"Description3","Office3",new Date()));
		}
		public List<Report> findAll(){
			return reports;
		}
		
		public Report deleteById(long doctorId,long patientId) {
			Report report=findById(doctorId,patientId);
			if(report==null) return null;
			if(reports.remove(report)) {
			return report;
			}
			return null;
		
		}

		Report findById(long doctorId,long patientId) {
			for(Report report:reports) {
				if(report.getPatientID()==patientId && report.getDoctorID()==doctorId) {
					return report;
				}
			}
			return null;
		}
		public Report save(Report report) {
			if((report.getDoctorID()==-1 || report.getDoctorID()==0 )&& 
					report.getPatientID()==-1 || report.getPatientID()==0) {
				report.setDoctorID(10);
				report.setPatientID(++idCounter);
				reports.add(report);
				
			}
			else {
				deleteById(report.getDoctorID(), report.getPatientID());
				reports.add(report);
			}
			return report;
		}
}
