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
	 private Long PatientID;
	 private Long DoctorID;
	 private String Description;
	 private String Office;
	 private Date Date;
	 private long periodID;
	 
	 public Review() {
}
	 
		public Review(Long patientID, long doctorID, String description, String office, java.util.Date date, long PeriodID) {
			super();
			PatientID = patientID;
			DoctorID = doctorID;
			Description = description;
			Office = office;
			Date = date;
			periodID = PeriodID;
		}
		public Long getPatientID() {
			return PatientID;
		}
		
		
		
		
		public Long getPeriodID() {
			return periodID;
		}

		public void setPeriodID(Long periodID) {
			this.periodID = periodID;
		}

		public void setPatientID(Long patientID) {
			PatientID = patientID;
		}
		public long getDoctorID() {
			return DoctorID;
		}
		public void setDoctorID(Long doctorID) {
			DoctorID = doctorID;
		}
		public String getDescription() {
			return Description;
		}
		public void setDescription(String description) {
			Description = description;
		}
		public String getOffice() {
			return Office;
		}
		public void setOffice(String office) {
			Office = office;
		}
		public Date getDate() {
			return Date;
		}
		public void setDate(Date date) {
			Date = date;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((Date == null) ? 0 : Date.hashCode());
			result = prime * result
					+ ((Description == null) ? 0 : Description.hashCode());
			result = prime * result + (int) (DoctorID ^ (DoctorID >>> 32));
			result = prime * result
					+ ((Office == null) ? 0 : Office.hashCode());
			result = prime * result + (int) (PatientID ^ (PatientID >>> 32));
			result = prime * result + (int) (periodID ^ (periodID >>> 32));
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
			if (Date == null) {
				if (other.Date != null)
					return false;
			} else if (!Date.equals(other.Date))
				return false;
			if (Description == null) {
				if (other.Description != null)
					return false;
			} else if (!Description.equals(other.Description))
				return false;
			if (DoctorID != other.DoctorID)
				return false;
			if (Office == null) {
				if (other.Office != null)
					return false;
			} else if (!Office.equals(other.Office))
				return false;
			if (PatientID != other.PatientID)
				return false;
			if (periodID != other.periodID)
				return false;
			return true;
		}

		

	

	
	
		
		
		
	 
	 
	 
}
