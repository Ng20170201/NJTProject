package com.NJTProject.rest.webservices.restwebservices.Review;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.NJTProject.rest.webservices.restwebservices.Report.Report;

@Entity
public class Review {
	@Id
	@GeneratedValue
	 private Long patientid;
	 private Long doctorid;
	 private String description;
	 private String office;
	 private Date date;
	
	 public Review() {
}
	 
		public Review(Long patientid, long doctorid, String description, String office, java.util.Date date) {
			super();
			patientid = patientid;
			doctorid = doctorid;
			description = description;
			office = office;
			date = date;
		
		}
		public Long getPatientID() {
			return patientid;
		}
		
		

		public void setPatientID(Long patientID) {
			patientid = patientID;
		}
		public long getDoctorID() {
			return doctorid;
		}
		public void setDoctorID(Long doctorID) {
			doctorid = doctorID;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			description = description;
		}
		public String getOffice() {
			return office;
		}
		public void setOffice(String office) {
			office = office;
		}
		public Date getDate() {
			return date;
		}
		public void setDate(Date date) {
			date = date;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((date == null) ? 0 : date.hashCode());
			result = prime * result
					+ ((description == null) ? 0 : description.hashCode());
			result = prime * result + (int) (doctorid ^ (doctorid >>> 32));
			result = prime * result
					+ ((office == null) ? 0 : office.hashCode());
			result = prime * result + (int) (patientid ^ (patientid >>> 32));
			
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Review other = (Review) obj;
			if (date == null) {
				if (other.date != null)
					return false;
			} else if (!date.equals(other.date))
				return false;
			if (description == null) {
				if (other.description != null)
					return false;
			} else if (!description.equals(other.description))
				return false;
			if (doctorid != other.doctorid)
				return false;
			if (office == null) {
				if (other.office != null)
					return false;
			} else if (!office.equals(other.office))
				return false;
			if (patientid != other.patientid)
				return false;
			
			return true;
		}

		

	

	
	
		
		
		
	 
	 
	 
}
